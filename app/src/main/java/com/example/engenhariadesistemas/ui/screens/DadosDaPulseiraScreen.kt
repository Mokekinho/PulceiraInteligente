package com.example.engenhariadesistemas.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.engenhariadesistemas.ui.components.Title
import com.example.engenhariadesistemas.ui.components.TopAppBar

@Composable
fun DadosDaPulseiraScreen(innerPadding: PaddingValues){
    Column (
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .padding(15.dp)
    ){
        Title("Status da pulseira")
    }
}