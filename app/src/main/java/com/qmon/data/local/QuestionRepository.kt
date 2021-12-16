package com.qmon.data.local

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.qmon.domain.Question
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class QuestionRepository(
    private val appContext: Context,
    private val prefs: SharedPreferences
) {
    private val questions = readQuestions()
        .filter { it.question.isNotBlank() && it.answers.isNotEmpty() }

    private fun readQuestions(): List<Question> {
        val questionsJson = appContext.assets.open(QUESTIONS_FILE_NAME).bufferedReader()
            .use { it.readText() }
        return Json.decodeFromString(questionsJson)
    }

    suspend fun getNextQuestion(): Question {
        increaseQuestionIndex()
        return getCurrQuestion()
    }

    suspend fun getCurrQuestion() = questions[getQuestionIndex() % questions.size]

    suspend fun isAdQuestion() = getQuestionIndex() % AD_QUESTION_PERIOD == 0

    private suspend fun getQuestionIndex() = withContext(Dispatchers.IO) {
        prefs.getInt(QUESTION_INDEX_KEY, 0)
    }

    @SuppressLint("ApplySharedPref")
    private suspend fun increaseQuestionIndex() = withContext(Dispatchers.IO) {
        val currIndex = getQuestionIndex()
        prefs.edit().apply {
            putInt(QUESTION_INDEX_KEY, currIndex + 1)
            commit()
        }
    }

    companion object {
        private const val QUESTIONS_FILE_NAME = "q.json"

        private const val QUESTION_INDEX_KEY = "questionIndex"

        private const val AD_QUESTION_PERIOD = 2
    }
}