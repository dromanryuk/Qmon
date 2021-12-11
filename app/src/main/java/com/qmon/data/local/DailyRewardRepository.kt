package com.qmon.data.local

import android.content.SharedPreferences
import com.qmon.domain.DailyReward
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext

class DailyRewardRepository(
    private val prefs: SharedPreferences,
    private val coinsRepository: CoinsRepository
) {
    private val rewards = MutableStateFlow(emptyList<DailyReward>())

    init {
        resetIfExpired()
        updateRewards()
    }

    private fun resetIfExpired() {
        val collectionMillis = getLastCollectionMillis() ?: 0
        if (isCollectionExpired(collectionMillis))
            resetDailyReward()
    }

    private fun getLastCollectionMillis() =
        prefs.getLong(LAST_COLLECTION_MILLIS_KEY, -1).takeIf { it != -1L }

    private fun isCollectionExpired(collectionMillis: Long) =
        System.currentTimeMillis() - collectionMillis > 2 * DAY_IN_MILLIS

    private fun resetDailyReward() {
        prefs.edit().run {
            this.remove(LAST_COLLECTION_MILLIS_KEY)
            this.remove(LAST_COLLECTED_DAY_KEY)
            apply()
        }
    }

    private fun updateRewards() {
        val lastCollectedDay = getLastCollectedDay() ?: 0
        rewards.value = (1..30).map {
            DailyReward(
                day = it,
                isCollected = it <= lastCollectedDay
            )
        }
    }

    private fun getLastCollectedDay() =
        prefs.getInt(LAST_COLLECTED_DAY_KEY, -1).takeIf { it != -1 }

    fun observeRewards() = rewards.asStateFlow()

    suspend fun tryCollectReward(day: Int) = withContext(Dispatchers.IO) {
        val collectionMillis = getLastCollectionMillis()
        val lastDayCollected = getLastCollectedDay() ?: 0
        if (canCollectByTime(collectionMillis) && lastDayCollected + 1 == day)
            collectReward()
    }

    private suspend fun collectReward() = withContext(Dispatchers.IO) {
        val lastCollectedDay = getLastCollectedDay() ?: 0
        prefs.edit().run {
            putLong(LAST_COLLECTION_MILLIS_KEY, System.currentTimeMillis())
            putInt(LAST_COLLECTED_DAY_KEY, lastCollectedDay + 1)
            commit()
        }
        updateRewards()
        coinsRepository.increaseCoins(lastCollectedDay + 1)
    }

    private fun canCollectByTime(collectionMillis: Long?): Boolean {
        if (collectionMillis == null)
            return true
        val lastCollectionMillisAgo = System.currentTimeMillis() - collectionMillis
        return lastCollectionMillisAgo > DAY_IN_MILLIS && lastCollectionMillisAgo <= 2 * DAY_IN_MILLIS
    }

    companion object {
        private const val LAST_COLLECTION_MILLIS_KEY = "lastCollection"
        private const val LAST_COLLECTED_DAY_KEY = "lastCollectedDay"

        private const val DAY_IN_MILLIS = 24 * 60 * 60 * 1000
    }
}
