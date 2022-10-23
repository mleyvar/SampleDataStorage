package com.example.sampledatastore

import android.app.Application
import android.content.Context
import com.example.sampledatastore.data.database.Prefs
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AndroidApplication : Application() {
    companion object {
        lateinit var prefs: Prefs
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
        appContext = applicationContext
    }
}
