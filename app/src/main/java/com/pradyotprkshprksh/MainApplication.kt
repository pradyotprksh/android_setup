package com.pradyotprkshprksh

import android.app.Application
import com.pradyotprkshprksh.di.applicationModule
import com.pradyotprkshprksh.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * The main application layer of our class which will handle all the
 * initial flow of our project like initializing modules and all.
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(listOf(
                applicationModule,
                networkModule,
            ))
        }
    }

}