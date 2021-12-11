package com.qmon.presentation.overview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.qmon.presentation.components.BottomInfoPanel
import com.qmon.presentation.components.DefaultTopAppBar

@Composable
fun OverviewScreen(
    navigateToInstructionScreen: () -> Unit,
    navigateToQuestionScreen: () -> Unit,
    navigateToDailyBonusScreen: () -> Unit,
    navigateToWithdrawalScreen: () -> Unit,
    navigateToLegalInfoScreen: () -> Unit,
) {
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
            OverviewContent(
                navigateToQuestionScreen,
                navigateToDailyBonusScreen,
                navigateToWithdrawalScreen
            )
            BottomInfoPanel(
                navigateToInstructionScreen,
                navigateToLegalInfoScreen
            )
        }
    }
}