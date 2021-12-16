package com.qmon

import android.app.Activity
import com.appodeal.ads.Appodeal

fun Activity.initializeAppodeal() {
    Appodeal.initialize(this, APP_KEY, AD_TYPES)
}

private const val APP_KEY = "751b57b4e040b6b637a02d9df67a3f4988045678e5c15bd6"
const val AD_TYPES = Appodeal.INTERSTITIAL or Appodeal.NON_SKIPPABLE_VIDEO
