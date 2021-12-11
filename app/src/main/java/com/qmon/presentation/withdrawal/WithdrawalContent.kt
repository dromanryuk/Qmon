package com.qmon.presentation.withdrawal

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WithdrawalContent(coins: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "Вывод монет",
            modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 25.dp),
            color = Color.Black,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        WithdrawalRequestPanel(coins = coins)
        Spacer(modifier = Modifier.height(20.dp))
        WithdrawalHistoryPanel()
        Spacer(modifier = Modifier.height(30.dp))
    }
}