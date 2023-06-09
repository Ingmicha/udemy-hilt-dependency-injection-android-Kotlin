package com.ingmicha.android.compose.hilt.network

import android.util.Log
import javax.inject.Inject

class MyNetworkAdapter @Inject constructor() : NetworkAdapter {
    override fun log(message: String) {
        Log.d("MyNetworkAdapter", "MyNetworkAdapter: $message")
    }
}