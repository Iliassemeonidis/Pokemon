package com.example.pokemon.apppokemoon

import android.app.Application
import com.example.pokemon.di.application
import com.example.pokemon.di.detailsScreen
import com.example.pokemon.di.mainScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppPokemon : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(application, mainScreen, detailsScreen)
        }
    }
}