package com.qmon.presentation.question

import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.qmon.domain.model.Question

@Composable
fun QuestionContent(
    questions: List<Question>,
    showDialog: MutableState<Boolean>,
    sharedPreferences: SharedPreferences
) {
    val gradient = Brush.verticalGradient(
        listOf(
            Color(0xfff9801c),
            Color(0xfff36500),
            Color(0xfff36500),
            Color(0xfff36500),
            Color(0xfff9801c)
        )
    )
    var lastIndex = 0
    questions.forEach {
        if (it.question.isNotEmpty()) {
            lastIndex += 1
        }
    }
    val questionNumber = remember { mutableStateOf(0) }
    if (questionNumber.value == lastIndex) {
        questionNumber.value = 0
    }
    QuestionDialog(showDialog, questionNumber, sharedPreferences)
    if (questions[questionNumber.value].answers.isEmpty()) {
        ++questionNumber.value
    }
    QuestionCard(questions[questionNumber.value], gradient, showDialog)
}

@Composable
fun QuestionCard(question: Question, gradient: Brush, showDialog: MutableState<Boolean>) {
    Column(
        modifier = Modifier
            .padding(40.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.height(90.dp),
            text = question.question,
            style = MaterialTheme.typography.h5,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(30.dp))
        question.answers.forEach { answer ->
            DefaultQuestionButton(answer, gradient, showDialog)
            Spacer(modifier = Modifier.height(30.dp))
        }
        Text(
            text = "За этот вопрос вы \n" +
                    "получите 1 монету",
            style = MaterialTheme.typography.body1,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
    }
}