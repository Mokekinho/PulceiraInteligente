package com.example.engenhariadesistemas.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopAppBar(
    title : String
){
    Spacer(
        Modifier.height(10.dp)
    )
    Text(
        text = title,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold
    )
    Spacer(
        Modifier.height(30.dp)
    )
}