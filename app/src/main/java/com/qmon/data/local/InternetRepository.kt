package com.qmon.data.local

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class InternetRepository(
    private val applicationContext: Context,
) {
    fun observeInternetConnection() = flow {
        while (true) {
            emit(isOnline())
            delay(1000)
        }
    }

    private fun isOnline(): Boolean {
        getConnectivityMan()?.let { conMan ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val capabilities = conMan.getNetworkCapabilities(conMan.activeNetwork)
                capabilities?.let {
                    return when {
                        it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        it.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                        else -> false
                    }
                }
            } else {
                return conMan.activeNetworkInfo?.isConnected == true
            }
        }
        return false
    }

    private fun getConnectivityMan() =
        applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager?
}