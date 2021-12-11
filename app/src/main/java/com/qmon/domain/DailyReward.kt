package com.qmon.domain

data class DailyReward(
    val day: Int,
    val isCollected: Boolean = false
)