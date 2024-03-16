package com.example.movieappprojectmvvm.models

data class InfoData(
    val country: String,
    val genres: List<String>,
    val id: Int,
    val images: List<String>,
    val imdbRating: String, // corrected field name
    val poster: String,
    val title: String,
    val year: String
)
