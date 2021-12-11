package com.qmon.domain.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.qmon.domain.model.Question
import java.io.BufferedReader

fun readJsonFile(inputStream: BufferedReader): List<Question> {
    val gson = Gson()
    val inputString = inputStream.use { it.readText() }
    val listQuestionType = object : TypeToken<List<Question>>() {}.type
    val questions: List<Question> = gson.fromJson(inputString, listQuestionType)
    println("=================== $questions")
    return questions
}