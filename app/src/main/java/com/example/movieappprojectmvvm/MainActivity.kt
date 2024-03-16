package com.example.movieappprojectmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movieappprojectmvvm.navigation.Navigation
import com.example.movieappprojectmvvm.ui.theme.MovieAppProjectMvvmTheme
import com.example.movieappprojectmvvm.viewModel.MovieViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppProjectMvvmTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


//                    Text(text = state.movies.toString())
                    Navigation()
////                    HelloContent()
                }
            }
        }
    }
}

//@Composable
//fun HelloContent() {
//    Column(modifier = Modifier.fillMaxSize()) {
//        Text(text = "Hello")
//    }
//}


