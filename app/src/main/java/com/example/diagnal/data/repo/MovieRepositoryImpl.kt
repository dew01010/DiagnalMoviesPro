package com.example.diagnal.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.diagnal.data.model.Movies
import com.example.diagnal.data.paging.MoviePagingSource
import com.example.diagnal.data.service.MovieApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val service: MovieApi,
) : MovieRepo {

    override suspend fun fetchMovies(): Flow<PagingData<Movies>> = Pager(
        config = PagingConfig(pageSize = 6, prefetchDistance = 2),
        pagingSourceFactory = { MoviePagingSource(service) }
    ).flow

}