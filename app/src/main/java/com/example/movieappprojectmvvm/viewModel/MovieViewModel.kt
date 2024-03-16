package com.example.movieappprojectmvvm.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappprojectmvvm.models.InfoData
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel(){ //MovieViewModel-subclass
    private val repository = Repository() //handle data operations
    var isLoading by mutableStateOf(false)
    var state by mutableStateOf(ScreenState())//holds the current state of the screen

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        isLoading = true // Set loading state to true when data loading starts
        viewModelScope.launch {
            try {
                val response = repository.getMovieList(state.page)
                state = state.copy(
                    movies = response.body()!!.data
                )
            } catch (e: Exception) {
                // Handle error
            } finally {
                isLoading = false // Set loading state to false when data loading completes
            }
        }
    }

}

data class ScreenState(
    val movies: List<InfoData> = emptyList(),
    val page: Int = 1
)

//fetches movie data asynchronously from a repository using coroutines
// and updates the UI state using mutable state
//it goes to the repository.kt -> ApiInterface