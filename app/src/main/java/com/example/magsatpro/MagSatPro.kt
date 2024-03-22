package com.example.magsatpro

import android.app.Application
import com.example.magsatpro.di.KoinAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MagSatPro: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MagSatPro)
            modules(KoinAppModule)
        }
    }
}