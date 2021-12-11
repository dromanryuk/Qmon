package com.qmon.presentation.withdrawal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import com.qmon.presentation.components.defaultScaffoldBgColor
import com.qmon.qmonApp
import com.qmon.ui.theme.WithdrawalScreenBgColor

@Composable
fun WithdrawalScreen() {
    DisposableEffect(Unit) {
        defaultScaffoldBgColor.value = WithdrawalScreenBgColor
        onDispose {
            defaultScaffoldBgColor.value = Color.White
        }
    }
    val coins by qmonApp.coinsRepository.coins.collectAsState()
    WithdrawalContent(coins = coins)
}