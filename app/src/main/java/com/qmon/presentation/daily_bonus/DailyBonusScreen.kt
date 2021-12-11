package com.qmon.presentation.daily_bonus

import android.content.SharedPreferences
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
fun DailyBonusScreen(
    navigateToInstructionScreen: () -> Unit,
    navigateToLegalInfoScreen: () -> Unit,
    sharedPreferences: SharedPreferences,
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
            DailyBonusContent(sharedPreferences)
            BottomInfoPanel(
                navigateToInstructionScreen,
                navigateToLegalInfoScreen
            )
        }
    }
}