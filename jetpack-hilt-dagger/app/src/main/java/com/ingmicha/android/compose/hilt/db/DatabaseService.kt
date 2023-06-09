package com.ingmicha.android.compose.hilt.db

import android.util.Log
import javax.inject.Inject

class DatabaseService @Inject constructor() {
    fun log(message: String) {
        Log.d(TAG, "Database Service message : $message")
    }

    companion object {
        const val TAG: String = "DatabaseService"
    }
}