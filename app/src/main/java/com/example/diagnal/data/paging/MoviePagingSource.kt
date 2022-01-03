package com.example.diagnal.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.diagnal.data.model.Movies
import com.example.diagnal.data.service.MovieApi

class MoviePagingSource(private val service: MovieApi) :
    PagingSource<Int, Movies>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movies> {
        val pageNumber = params.key ?: 1
        return try {
            val response = service.getMovies(pageNumber)
            val data = response.page?.contentItem?.movies ?: arrayListOf()

            var nextPageNumber: Int? = null
            if (response.page?.contentItem != null) {
                nextPageNumber = response.page.pageNo.toInt().plus(1)
            }

            LoadResult.Page(
                data = data,
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movies>): Int? {
        return 1
    }
}