package com.ingmicha.android.compose.hilt.db

import android.content.Context
import android.util.Log
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class DatabaseAdapter @Inject constructor(
    @ActivityContext private val context: Context,
    var databaseService: DatabaseService
) {
    fun log(message: String) {
        Log.d(TAG, "Database Adapter message: $message")
        databaseService.log(message)
        Log.d(TAG, "Context available: $context")

    }

    companion object {
        const val TAG = "DatabaseAdapter"
    }
}