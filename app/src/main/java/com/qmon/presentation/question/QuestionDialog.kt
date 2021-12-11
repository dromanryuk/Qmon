package com.qmon.presentation.question

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.qmon.ui.theme.QmonTheme

@Composable
fun QuestionDialog(
    onConfirmAnswer: () -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = {}) {
        QuestionDialogContent(
            onConfirmAnswer = onConfirmAnswer,
            onChangeAnswer = onDismiss
        )
    }
}

@Composable
private fun QuestionDialogContent(
    onConfirmAnswer: () -> Unit,
    onChangeAnswer: () -> Unit
) {
    Card {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Подтвердите ответ",
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Если вы уверены, что честно и\n" +
                        "правильно ответили на вопрос,\n" +
                        "нажмите «Подтвердить»",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button(
                    modifier = Modifier.height(55.dp),
                    onClick = onConfirmAnswer,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xff0046d0),
                        contentColor = Color.White
                    )
                ) {
                    Text("Подтверждаю", fontWeight = FontWeight.Bold)
                }
                Button(
                    modifier = Modifier.height(55.dp),
                    onClick = onChangeAnswer,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xffb1b1b1),
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        "Поменять\nответ",
                        textAlign = TextAlign.Center,
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun QuestionDialogContentPreview() {
    QmonTheme {
        QuestionDialogContent({}, {})
    }
}