package com.ingmicha.android.compose.hilt.network

import android.util.Log
import javax.inject.Inject

class CallInterceptorImpl @Inject constructor() : Interceptor {
    override fun log(message: String) {
        Log.d("CallInterceptorImpl", "This is a cell interceptor: $message")
    }
}