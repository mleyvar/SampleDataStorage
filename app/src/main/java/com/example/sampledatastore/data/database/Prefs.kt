package com.example.sampledatastore.data.database

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {

    private val PREFS_NAME = "com.example.sampledatastore.sharedpreferences"

    private val SHARED_NAME = "SHARED_NAME"
    private val SHARED_AMOUNT = "SHARED_AMOUNT"
    private val SHARED_AGE = "SHARED_AGE"
    private val SHARED_IS_PET = "SHARED_IS_PET"

    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    var name: String
        get() = prefs.getString(SHARED_NAME, "") ?: ""
        set(value) = prefs.edit().putString(SHARED_NAME, value).apply()

    var amount: Float
        get() = prefs.getFloat(SHARED_AMOUNT, 0.0F)
        set(value) = prefs.edit().putFloat(SHARED_AMOUNT, value).apply()

    var age: Int
        get() = prefs.getInt(SHARED_AGE, 0)
        set(value) = prefs.edit().putInt(SHARED_AGE, value).apply()

    var isPet: Boolean
        get() = prefs.getBoolean(SHARED_IS_PET, false)
        set(value) = prefs.edit().putBoolean(SHARED_IS_PET, value).apply()
}
