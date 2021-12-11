package com.qmon.presentation.question

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qmon.domain.Question
import com.qmon.ui.theme.QmonTheme

@Composable
fun QuestionContent(
    question: Question,
    onAnswerClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(40.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = question.question,
            style = MaterialTheme.typography.h5,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        question.answers.forEach { answer ->
            DefaultQuestionButton(
                text = answer,
                onClick = onAnswerClick
            )
        }
        Text(
            text = "За этот вопрос вы \n" +
                    "получите 1 монету",
            color = Color.Gray,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Thin,
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun QuestionContentPreview() {
    QmonTheme {
        QuestionContent(
            question = Question(
                question = "Тестовый вопрос?",
                answers = listOf("Да", "Нет", "Затрудняюсь ответить")
            ),
            onAnswerClick = {}
        )
    }
}