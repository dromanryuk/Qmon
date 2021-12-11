package com.qmon.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.qmon.qmonApp

@Composable
fun DefaultScaffold(
    navigateToInstructionScreen: () -> Unit,
    content: @Composable () -> Unit
) {
    val coins by qmonApp.coinsRepository.coins.collectAsState()
    Scaffold(
        backgroundColor = defaultScaffoldBgColor.value,
        topBar = {
            DefaultTopAppBar(
                coins = coins,
                navigateToInstructionScreen = navigateToInstructionScreen
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.weight(1f)
            ) {
                content()
            }
            BottomInfoPanel(
                navigateToInstructionScreen = navigateToInstructionScreen,
                navigateToLegalScreen = {}
            )
        }
    }
}

val defaultScaffoldBgColor = mutableStateOf(Color.White)