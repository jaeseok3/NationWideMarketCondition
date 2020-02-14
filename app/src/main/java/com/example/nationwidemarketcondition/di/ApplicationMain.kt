package com.example.nationwidemarketcondition.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ApplicationMain: Application() {
    companion object{
        lateinit var instance: ApplicationMain private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            androidContext(this@ApplicationMain)
            androidLogger(level = Level.ERROR)
            modules(listOf(viewModelModule, networkServerModule, repositoryModule, retrofitModule, testModule))
        }
    }
}