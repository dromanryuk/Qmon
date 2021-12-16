package com.qmon

import android.app.Application
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.qmon.data.local.*
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
    var legalInfoRepository: LegalInfoRepository by Delegates.notNull()
        private set

    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = getSharedPreferences("Coins", Context.MODE_PRIVATE)
        questionRepository = QuestionRepository(applicationContext, sharedPreferences)
        coinsRepository = CoinsRepository(sharedPreferences)
        internetRepository = InternetRepository(applicationContext)
        dailyRewardRepository = DailyRewardRepository(sharedPreferences, coinsRepository)
        legalInfoRepository = LegalInfoRepository(applicationContext, sharedPreferences)
    }
}

val qmonApp
    @Composable
    get() = LocalContext.current.applicationContext as QmonApp