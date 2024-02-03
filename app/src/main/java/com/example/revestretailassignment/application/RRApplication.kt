package com.example.revestretailassignment.application

import android.app.Application
import com.example.revestretailassignment.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class RRApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        koinInit()
    }

    private fun koinInit() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@RRApplication)
            modules(provideDependency())
        }
    }

    private fun provideDependency() = appComponent
}