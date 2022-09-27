package dev.queen.contacts

import android.app.Application
import android.content.Context

class Contacts : Application() {
    companion object{
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext

    }
}