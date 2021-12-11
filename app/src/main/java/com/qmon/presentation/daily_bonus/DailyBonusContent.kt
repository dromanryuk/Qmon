package com.qmon.presentation.daily_bonus

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qmon.domain.DailyReward

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DailyBonusContent(
    dailyRewards: List<DailyReward>,
    onCollect: (day: Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Получайте ежедневные бонусы за открытие приложения Qmon",
            style = MaterialTheme.typography.h6,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            items(dailyRewards, key = { it.day }) {
                DefaultRewardPanel(
                    day = it.day,
                    isCollected = it.isCollected,
                    onCollect = { onCollect(it.day) }
                )
            }
        }
    }
}