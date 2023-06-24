package com.example.ghiblicollection.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ghiblicollection.data.Movies
import com.example.ghiblicollection.ui.theme.GhibliCollectionTheme

@Suppress("DEPRECATION")
class DetailActivity : ComponentActivity() {

    companion object {
        private const val MOVIE = "movie"

        fun navigateScreen(context: Context, movies: Movies) = Intent(context, DetailActivity::class.java)
            .apply{ putExtra(MOVIE, movies) }
    }

    private val movie: Movies by lazy{
        intent?.getSerializableExtra(MOVIE) as Movies
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GhibliCollectionTheme {
                DetailScreen(movies = movie)
            }
        }
    }
}