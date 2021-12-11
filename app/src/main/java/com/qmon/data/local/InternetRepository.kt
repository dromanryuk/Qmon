package com.qmon.data.local

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.qmon.domain.util.isOnline
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class InternetRepository(
    private val applicationContext: Context,
) {

    @RequiresApi(Build.VERSION_CODES.M)
    @FlowPreview
    var internetConnectionFlow = flow {
        while (true) {
            emit(isOnline(applicationContext))
            delay(1000)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @FlowPreview
    fun checkConnection() {
        internetConnectionFlow = flow {
            emit(isOnline(applicationContext))
        }
    }

    //@FlowPreview
    //val internetConnectionStateFlow =  internetConnectionFlow as StateFlow<Boolean>

//    @FlowPreview
//    fun getConnectionState(): Boolean {
//        println("XAXAAXAXAXAXAXAXAXAXAXAXAXAXAXAXAXAXAXAXAXAXAXAXAXAX")
//        var value = false
//        coroutineScope {
//            launch {
//
//            }
//            internetConnectionFlow.collect {
//                value = it
//            }
//        }
//        return value
//    }
}