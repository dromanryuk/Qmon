package com.qmon.presentation.question

import androidx.compose.runtime.*
import com.qmon.domain.Question
import com.qmon.qmonApp
import kotlinx.coroutines.launch

@Composable
fun QuestionScreen() {
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
                }
                showDialog = false
            },
            onDismiss = { showDialog = false }
        )
}