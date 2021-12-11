package com.qmon.presentation.question

import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.qmon.QmonApp

@Composable
fun QuestionDialog(
    showDialog: MutableState<Boolean>,
    questionNumber: MutableState<Int>,
    sharedPreferences: SharedPreferences
) {
    val qmonApp = LocalContext.current.applicationContext as QmonApp
    val coinsRepository = qmonApp.coinsRepository

    if (showDialog.value) {
        Dialog(
            onDismissRequest = {  }
        ) {
            Card {
                Column(
                    modifier = Modifier
                        .padding(20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "Подтвердите ответ",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Если вы уверены, что честно и\n" +
                                "правильно ответили на вопрос,\n" +
                                "нажмите «Подтвердить»",
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Center,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Button(
                            modifier = Modifier
                                .padding(end = 5.dp)
                                .height(45.dp),
                            onClick = {
                                coinsRepository?.increaseCoinsCount(sharedPreferences)
                                questionNumber.value++
                                showDialog.value = false
                            },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xff0046d0),
                                contentColor = Color.White
                            )
                        ) {
                            Text("Подтверждаю")
                        }
                        Button(
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .height(45.dp),
                            onClick = { showDialog.value = false },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xffb1b1b1),
                                contentColor = Color.White
                            )
                        ) {
                            Text(
                                "Поменять\nответ",
                                fontSize = 12.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}

fun putPreferences(sharedPreferences: SharedPreferences, coins: Int) {
    val editor = sharedPreferences.edit()
    val coinsCount = sharedPreferences.getInt("coinsCount", 0)
    editor.putInt("coinsCount", coinsCount + coins)
    editor.apply()
}