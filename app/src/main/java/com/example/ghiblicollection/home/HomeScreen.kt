package com.example.ghiblicollection.home

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.ghiblicollection.data.Movies
import com.example.ghiblicollection.data.MoviesData.movies

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navigateToDetail: (Movies) -> Unit){
    val moviesItem = remember{ movies }
    LazyColumn(
        contentPadding = PaddingValues(
            horizontal = 12.dp,
            vertical = 16.dp
        )
    ) {
        items(
            items = moviesItem,
            itemContent = { MovieListItem(movies = it, navigateToDetail) }
        )
    }
}

@Composable
fun MovieListItem(movies: Movies, navigateToDetail: (Movies) -> Unit){
    Card(
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ){
        Row(
            Modifier.clickable {
                navigateToDetail(movies)
            }
        ){
            AsyncImage(
                model = movies.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(12.dp)
                    .size(68.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(8.dp)))
            )
            Text(
                text = movies.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(start = 16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}