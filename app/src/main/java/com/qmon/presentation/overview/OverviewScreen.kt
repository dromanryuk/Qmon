package com.qmon.presentation.overview

import androidx.compose.runtime.Composable

@Composable
fun OverviewScreen(
    navigateToQuestionScreen: () -> Unit,
    navigateToDailyBonusScreen: () -> Unit,
    navigateToWithdrawalScreen: () -> Unit,
) {
    OverviewContent(
        navigateToQuestionScreen,
        navigateToDailyBonusScreen,
        navigateToWithdrawalScreen
    )
}