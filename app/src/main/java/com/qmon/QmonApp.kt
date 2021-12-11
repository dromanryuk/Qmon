package com.qmon

import android.app.Application
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.qmon.data.local.CoinsRepository
import com.qmon.data.local.DailyRewardRepository
import com.qmon.data.local.InternetRepository
import com.qmon.data.local.QuestionRepository
import kotlin.properties.Delegates

class QmonApp : Application() {
    var questionRepository: QuestionRepository by Delegates.notNull()
        private set
    var coinsRepository: CoinsRepository by Delegates.notNull()
        private set
    var internetRepository: InternetRepository by Delegates.notNull()
        private set
    var dailyRewardRepository: DailyRewardRepository by Delegates.notNull()
        private set

    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = getSharedPreferences("Coins", Context.MODE_PRIVATE)
        questionRepository = QuestionRepository(applicationContext, sharedPreferences)
        coinsRepository = CoinsRepository(sharedPreferences)
        internetRepository = InternetRepository(applicationContext)
        dailyRewardRepository = DailyRewardRepository(sharedPreferences, coinsRepository)
    }
}

val qmonApp
    @Composable
    get() = LocalContext.current.applicationContext as QmonApp