package com.example.diagnal.di.module

import com.example.diagnal.data.repo.MovieRepo
import com.example.diagnal.data.repo.MovieRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class MovieRepoModule {

    @Binds
    abstract fun bindMovieRepo(movieRepositoryImpl: MovieRepositoryImpl): MovieRepo
}