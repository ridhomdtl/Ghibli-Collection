package com.example.ghiblicollection.about

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ghiblicollection.ui.theme.GhibliCollectionTheme

class AboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            GhibliCollectionTheme{
                AboutScreen()
            }
        }
    }
}