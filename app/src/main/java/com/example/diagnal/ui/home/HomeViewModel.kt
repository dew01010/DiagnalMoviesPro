package com.example.diagnal.ui.home

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.diagnal.base.BaseViewModel
import com.example.diagnal.data.model.Movies
import com.example.diagnal.data.repo.MovieRepositoryImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repo: MovieRepositoryImpl
) : BaseViewModel() {

    private lateinit var _moviesFlow: Flow<PagingData<Movies>>
    val moviesFlow: Flow<PagingData<Movies>>
        get() = _moviesFlow

    init {
        getAllMovies()
    }

    private fun getAllMovies() = launchPagingAsync({
        repo.fetchMovies().cachedIn(viewModelScope)
    }, {
        _moviesFlow = it
    })

}