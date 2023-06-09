package com.ingmicha.android.compose.hilt.network

import android.util.Log
import javax.inject.Inject

class ResponseInterceptorImpl @Inject constructor() : Interceptor {
    override fun log(message: String) {
        Log.d("ResponseInterceptorImpl", "This is a response interceptor: $message")
    }
}