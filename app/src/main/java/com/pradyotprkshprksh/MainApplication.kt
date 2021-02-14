package com.pradyotprkshprksh

import android.app.Application
import com.pradyotprkshprksh.di.applicationModule
import org.koin.android.ext.android.startKoin

/**
 * The main application layer of our class which will handle all the
 * initial flow of our project like initializing modules and all.
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(applicationModule))
    }

}