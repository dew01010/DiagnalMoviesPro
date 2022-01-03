package com.example.diagnal

import android.app.Application
import com.example.diagnal.di.component.AppComponent
import com.example.diagnal.di.component.DaggerAppComponent
import com.example.diagnal.di.module.AppModule

class MainApp : Application() {

    companion object {

        private lateinit var appComponent: AppComponent

        fun getAppComponent(): AppComponent {
            return appComponent
        }
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }
}