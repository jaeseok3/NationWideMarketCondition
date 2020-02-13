package com.example.nationwidemarketcondition.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApplicationMain: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ApplicationMain)
            modules(listOf(viewModelModule))
        }
    }
}