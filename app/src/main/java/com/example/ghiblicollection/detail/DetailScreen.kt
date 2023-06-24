package com.example.ghiblicollection.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.ghiblicollection.data.Movies

@Composable
fun DetailScreen(movies: Movies){

    val verticalScroll = rememberScrollState()

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(verticalScroll)
    ){
        MovieName(movies)
        MovieImage(movies)
        Spacer(modifier = Modifier.height(12.dp))
        MovieDesc(movies)
    }
}

@Composable
fun MovieImage(movies: Movies){
    Column(modifier = Modifier
        .fillMaxSize()
    ){
        AsyncImage(
            model = movies.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(319.dp)
                .width(209.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun MovieName(movies: Movies){
    Column(modifier = Modifier
        .fillMaxSize()
    ){
        Text(
            text = movies.name,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
    }
}

@Composable
fun MovieDesc(movies: Movies){
    Column(modifier = Modifier
        .fillMaxSize()
    ){
        Text(
            text = movies.desc,
            textAlign = TextAlign.Justify,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        )
    }
}
