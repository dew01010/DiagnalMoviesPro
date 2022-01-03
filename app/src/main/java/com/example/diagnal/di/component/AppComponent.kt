package com.example.diagnal.di.component

import com.example.diagnal.di.module.AppModule
import com.example.diagnal.di.module.MovieRepoModule
import com.example.diagnal.di.module.ViewModelModule
import com.example.diagnal.ui.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, MovieRepoModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(homeFragment: HomeFragment)

}