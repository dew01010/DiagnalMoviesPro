package com.example.diagnal.data.service

import android.app.Application
import com.example.diagnal.data.model.MovieResponse
import com.example.diagnal.util.getJsonDataFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class MovieApi @Inject constructor(private val applicationContext: Application) {

    fun getMovies(pageNumber: Int): MovieResponse {

        val filename = when (pageNumber) {
            1 -> {
                "movieapi1.json"
            }
            2 -> {
                "movieapi2.json"
            }
            3 -> {
                "movieapi3.json"
            }
            else -> {
                "movieapi1.json"
            }

        }

        val jsonFileString = getJsonDataFromAsset(applicationContext, fileName = filename)

        val gson = Gson()
        val movieType = object : TypeToken<MovieResponse>() {}.type

        val res: MovieResponse = gson.fromJson(jsonFileString, movieType)
        return res
    }

}