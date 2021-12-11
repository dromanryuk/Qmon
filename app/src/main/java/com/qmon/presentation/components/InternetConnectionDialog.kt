package com.qmon.presentation.components

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.qmon.QmonApp
import kotlinx.coroutines.FlowPreview
import kotlin.system.exitProcess

@RequiresApi(Build.VERSION_CODES.M)
@FlowPreview
@Composable
fun InternetConnectionDialog() {

    val qmonApp = LocalContext.current.applicationContext as QmonApp
    val internetRepository = qmonApp.internetRepository

    val showDialog = internetRepository?.internetConnectionFlow?.collectAsState(initial = true)

    if (!showDialog?.value!!) {
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
                        text = "Подключитесь к Интернету",
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center,
                        fontSize = 24.sp,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Проверьте подключение к сети.",
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
                                internetRepository.checkConnection()
                                //showDialog?.value = false
                            },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xff0046d0),
                                contentColor = Color.White
                            )
                        ) {
                            Text("Повторить")
                        }
                        Button(
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .height(45.dp),
                            onClick = {
                                //showDialog = false
                                exitProcess(0)
                            },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xffb1b1b1),
                                contentColor = Color.White
                            )
                        ) {
                            Text(
                                "Выйти",
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