package com.example.movieappprojectmvvm.viewModel

import com.example.movieappprojectmvvm.models.MoviesList
import com.example.movieappprojectmvvm.utils.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getMovieList(page:Int): Response<MoviesList> {
        return RetrofitInstance.api.getMovies(page)
    }
}