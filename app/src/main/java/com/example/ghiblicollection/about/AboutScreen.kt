package com.example.ghiblicollection.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun AboutScreen(){

    val verticalScroll = rememberScrollState()

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .verticalScroll(verticalScroll)
    ){
        Card(
            shape = CircleShape,
            elevation = 4.dp,
            modifier = Modifier
                .size(192.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            MyImage()
        }
        MyProfile()
    }

}

@Composable
fun MyImage(){
    Column(modifier = Modifier
        .fillMaxSize()
    ){
        Image(
            painter = rememberAsyncImagePainter("https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/small/avatar/dos:b2ce7b7ce9fbdb4b79d101bbb085d4fa20230218091052.png"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(192.dp)
                .width(192.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun MyProfile(){
    Column(modifier = Modifier
        .fillMaxSize()
    ){
        Text(
            text = "Ridho Mardhatillah",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 12.dp,
                    top = 24.dp,
                    bottom = 8.dp,
                    end = 12.dp)
        )
        Text(
            text = "a181dsx1155@bangkit.academy",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}