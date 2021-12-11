package com.qmon.presentation.withdrawal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WithdrawalContent() {
    Surface {
        Column(
            modifier = Modifier
                //.padding(40.dp)
                .fillMaxWidth()
                .background(Color(0xffcde8d4)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                text = "Вывод монет",
                modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 25.dp),
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                fontSize = 35.sp
            )
            Spacer(modifier = Modifier.height(30.dp))
            WithdrawalRequestPanel()
            Spacer(modifier = Modifier.height(20.dp))
            WithdrawalHistoryPanel()
        }
    }
}