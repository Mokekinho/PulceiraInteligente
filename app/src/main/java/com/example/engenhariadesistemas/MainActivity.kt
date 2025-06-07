package com.example.engenhariadesistemas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.engenhariadesistemas.ui.MainScreen
import com.example.engenhariadesistemas.ui.screens.HomeScreen
import com.example.engenhariadesistemas.ui.theme.EngenhariaDeSistemasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            MainScreen()

        }
    }
}

