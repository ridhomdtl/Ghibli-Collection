package com.example.ghiblicollection.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.ghiblicollection.about.AboutActivity
import com.example.ghiblicollection.data.Movies
import com.example.ghiblicollection.detail.DetailActivity
import com.example.ghiblicollection.ui.theme.GhibliCollectionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {


            GhibliCollectionTheme {
                GhibliCollectionApp{
                    val navigate = DetailActivity.navigateScreen(this, it)
                    startActivity(navigate)
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.BottomEnd
            ) {
                FloatingActionButton(
                    onClick = { startActivity(Intent(this@MainActivity, AboutActivity::class.java)) },
                    backgroundColor = Color.White,
                    contentColor = Color.Black,
                    elevation = FloatingActionButtonDefaults.elevation(4.dp),
                    modifier = Modifier
                        .padding(end = 16.dp, bottom = 24.dp)
                ) {
                    Icon(imageVector = Icons.Default.Info, contentDescription = "about_page")

                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GhibliCollectionApp(navigateToDetail: (Movies) -> Unit){
    Scaffold(
        content = {
            HomeScreen(navigateToDetail = navigateToDetail)
        }
    )
}
