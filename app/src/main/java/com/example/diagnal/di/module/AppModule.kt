package com.example.diagnal.di.module

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: Application) {
    @Provides
    fun providesApplicationContext(): Application = application
}