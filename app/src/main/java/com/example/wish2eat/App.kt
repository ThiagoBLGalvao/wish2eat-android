package com.example.wish2eat

import android.app.Application
import com.example.wish2eat.account.AccountModules
import com.example.wish2eat.home.HomeModules
import com.example.wish2eat.splashScreen.SplashModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)

            modules(listOf(AccountModules.instance, SplashModules.instance,HomeModules.instance))
        }
    }

    override fun onTerminate() {
        super.onTerminate()

        stopKoin()
    }
}