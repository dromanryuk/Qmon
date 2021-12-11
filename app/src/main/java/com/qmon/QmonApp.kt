package com.qmon

import android.app.Application
import android.content.Context
import com.qmon.data.local.CoinsRepository
import com.qmon.data.local.InternetRepository

class QmonApp : Application() {

    var coinsRepository: CoinsRepository? = null
    var internetRepository: InternetRepository? = null

//    companion object {
//        lateinit var qmon: Context
//    }

    override fun onCreate() {
        super.onCreate()
//        qmon = applicationContext

        val sharedPreferences = getSharedPreferences("Coins", Context.MODE_PRIVATE)
        coinsRepository = CoinsRepository(sharedPreferences)

        internetRepository = InternetRepository(applicationContext)
    }
}