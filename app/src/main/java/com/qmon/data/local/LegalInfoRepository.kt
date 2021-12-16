package com.qmon.data.local

import android.content.Context
import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LegalInfoRepository(
    private val appContext: Context,
    private val prefs: SharedPreferences
) {
    suspend fun getLegalInfo(): String = withContext(Dispatchers.IO) {
        appContext.assets.open(LEGAL_INFO_FILE_NAME).readBytes().toString(Charsets.UTF_8)
    }

    suspend fun shouldShowDialog() = withContext(Dispatchers.IO) {
        prefs.getBoolean(IS_FIRST_RUN_KEY, true)
    }

    fun onAcceptDialog() = prefs.edit().run {
        putBoolean(IS_FIRST_RUN_KEY, false)
        apply()
    }

    companion object {
        private const val LEGAL_INFO_FILE_NAME = "LegalInfo.txt"

        private const val IS_FIRST_RUN_KEY = "IsFirstRun"
    }
}