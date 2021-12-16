package com.qmon.presentation.question

import android.app.Activity
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import com.appodeal.ads.Appodeal
import com.qmon.AD_TYPES
import com.qmon.domain.Question
import com.qmon.qmonApp
import kotlinx.coroutines.launch

@Composable
fun QuestionScreen() {
    val context = LocalContext.current
    val questionRepository = qmonApp.questionRepository
    val coinsRepository = qmonApp.coinsRepository
    val coroutineScope = rememberCoroutineScope()

    var currQuestion by remember { mutableStateOf<Question?>(null) }
    var showDialog by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        coroutineScope.launch { currQuestion = questionRepository.getCurrQuestion() }
    }

    if (currQuestion != null)
        QuestionContent(
            currQuestion!!,
            onAnswerClick = { showDialog = true }
        )
    if (showDialog)
        QuestionDialog(
            onConfirmAnswer = {
                coroutineScope.launch {
                    coinsRepository.increaseCoins()
                    currQuestion = questionRepository.getNextQuestion()
                    if (questionRepository.isAdQuestion())
                        Appodeal.show(context as Activity, AD_TYPES)
                }
                showDialog = false
            },
            onDismiss = { showDialog = false }
        )
}