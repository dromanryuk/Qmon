package com.qmon.presentation.withdrawal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.qmon.presentation.components.BottomInfoPanel
import com.qmon.presentation.components.DefaultTopAppBar
import com.qmon.presentation.daily_bonus.DailyBonusContent

@Composable
fun WithdrawalScreen(
    navigateToInstructionScreen: () -> Unit,
    navigateToLegalInfoScreen: () -> Unit,
) {
    Scaffold(
        topBar = { DefaultTopAppBar(
            navigateToInstructionScreen = navigateToInstructionScreen
        ) },
        //contentColor = Color(0xffcde8d4)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().background(Color(0xffcde8d4)),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            WithdrawalContent()
            BottomInfoPanel(
                navigateToInstructionScreen,
                navigateToLegalInfoScreen
            )
        }
    }
}