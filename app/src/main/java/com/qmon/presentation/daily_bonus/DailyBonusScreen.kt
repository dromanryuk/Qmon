package com.qmon.presentation.daily_bonus

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import com.qmon.qmonApp
import kotlinx.coroutines.launch

@Composable
fun DailyBonusScreen() {
    val coroutineScope = rememberCoroutineScope()
    val dailyRewardRepository = qmonApp.dailyRewardRepository
    val dailyRewards by dailyRewardRepository.observeRewards().collectAsState()

    DailyBonusContent(
        dailyRewards = dailyRewards,
        onCollect = {
            coroutineScope.launch {
                dailyRewardRepository.tryCollectReward(it)
            }
        }
    )
}