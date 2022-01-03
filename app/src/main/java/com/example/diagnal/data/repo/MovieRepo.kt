package com.example.diagnal.data.repo

import androidx.paging.PagingData
import com.example.diagnal.data.model.Movies
import kotlinx.coroutines.flow.Flow

interface MovieRepo {
    suspend fun fetchMovies(): Flow<PagingData<Movies>>
}