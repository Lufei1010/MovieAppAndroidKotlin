package com.example.movieappprojectmvvm.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.movieappprojectmvvm.viewModel.MovieViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val movieViewModel = viewModel<MovieViewModel>()
    val state = movieViewModel.state

    Scaffold (
        modifier = Modifier.background(Color.Transparent),
        topBar = {
            TopBar()
        },
        content = { paddingValues ->
            if (movieViewModel.isLoading) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Loading")
                    Spacer(modifier = Modifier.height(8.dp))
                    CircularProgressIndicator()
                }
            }  else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                        .background(
                            Color.Transparent
                        ),
                    content = {
                        items(state.movies.size){
                            ItemUi(itemIndex = it, moviesList = state.movies, viewModel = movieViewModel, navController = navController)
                        }
                    }
                )
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    TopAppBar(title = { Text(text = "Movie App") })
//        ,
//        colors = TopAppBarDefaults.topAppBarColors(
//            containerColor = Color.White.copy(4f)
//        ))
}

