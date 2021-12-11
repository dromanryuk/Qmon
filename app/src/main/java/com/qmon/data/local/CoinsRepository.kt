package com.qmon.data.local

import android.content.SharedPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class CoinsRepository(
    private val sharedPreferences: SharedPreferences,
) {

    private val _coins = MutableStateFlow(0)
    val coins = _coins as StateFlow<Int>

    init {
        getCoins()
    }

    fun getCoins() {
        _coins.value = sharedPreferences.getInt("coinsCount", 0)
    }

    fun getCoin(): Int {
        getCoins()
        return _coins.value
    }

//    fun putPreferences(sharedPreferences: SharedPreferences, coins: Int) {
//        val editor = sharedPreferences.edit()
//        val coinsCount = sharedPreferences.getInt("coinsCount", 0)
//        editor.putInt("coinsCount", coinsCount + coins)
//        editor.apply()
//    }

    fun increaseCoinsCount(sharedPreferences: SharedPreferences) {
        val editor = sharedPreferences.edit()
        val coinsCount = sharedPreferences.getInt("coinsCount", 0)
        editor.putInt("coinsCount", coinsCount + 1)
        editor.apply()
        getCoins()
    }

    fun increaseCoinsCountBy(sharedPreferences: SharedPreferences, count: Int) {
        val editor = sharedPreferences.edit()
        val coinsCount = sharedPreferences.getInt("coinsCount", 0)
        editor.putInt("coinsCount", coinsCount + count)
        editor.apply()
        getCoins()
    }

}