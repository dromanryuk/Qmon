package com.qmon.data.local

import android.annotation.SuppressLint
import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext


class CoinsRepository(
    private val prefs: SharedPreferences,
) {
    private val _coins = MutableStateFlow(getCoins())
    val coins = _coins.asStateFlow()

    private fun getCoins() = prefs.getInt(COINS_KEY, 0)

    @SuppressLint("ApplySharedPref")
    suspend fun increaseCoins(count: Int = 1): Unit = withContext(Dispatchers.IO) {
        _coins.value += count
        prefs.edit().run {
            putInt(COINS_KEY, _coins.value)
            commit()
        }
    }

    companion object {
        private const val COINS_KEY = "coins"
    }
}