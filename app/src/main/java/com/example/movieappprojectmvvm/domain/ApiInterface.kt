package com.example.movieappprojectmvvm.domain

import com.example.movieappprojectmvvm.models.MoviesList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("movies?")
    suspend fun getMovies(
        @Query("page")page: Int
    ): Response<MoviesList>
}

