package com.qmon.presentation.question

import android.content.SharedPreferences
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.qmon.domain.model.Question
import com.qmon.presentation.components.BottomInfoPanel
import com.qmon.presentation.components.DefaultTopAppBar

@Composable
fun QuestionScreen(
    questions: List<Question>,
    navigateToInstructionScreen: () -> Unit,
    navigateToLegalInfoScreen: () -> Unit,
    sharedPreferences: SharedPreferences
) {
    val showDialog = remember { mutableStateOf(false) }
    Scaffold(
        topBar = { DefaultTopAppBar(
            navigateToInstructionScreen = navigateToInstructionScreen
        ) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            QuestionContent(questions, showDialog, sharedPreferences)
            BottomInfoPanel(
                navigateToInstructionScreen,
                navigateToLegalInfoScreen
            )
        }
    }
}