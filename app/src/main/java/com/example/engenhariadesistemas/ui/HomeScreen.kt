package com.example.engenhariadesistemas.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.engenhariadesistemas.ui.theme.Creme
import com.example.engenhariadesistemas.ui.theme.LightPurple
import com.example.engenhariadesistemas.ui.theme.LightRed
import com.example.engenhariadesistemas.R


@Composable
fun HomeScreen(){
    Text(
        text = "Dados Vitais",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
    Box(
        modifier = Modifier
            .background(Creme)
            .fillMaxSize()
            .padding(top = 30.dp)
            .padding(5.dp)
    ){
        Column(

        ) {
            Text(
                text = "Dados Vitais",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
            Row {
                Graph(
                    nome = "Heart Rate",
                    value = 98,
                    unit = "bpm",
                    color = LightRed,
                    modifier = Modifier
                        .weight(1f)
                )
                Graph(
                    nome = "Respiratory Rate",
                    value = 15,
                    unit = "rpm",
                    color = LightPurple,
                    modifier = Modifier
                        .weight(1f)
                )
            }

            Text(
                text = "Localização do Paciente",
                fontSize = 20.sp
            )
            Location()
        }
    }
}

@Composable
fun Graph(
    nome: String,
    value: Int,
    unit: String,
    color: Color,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(Color.White, RoundedCornerShape(20.dp))
            .padding(10.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .background(color, RoundedCornerShape(15.dp))
            )
            Spacer(
                modifier = Modifier
                    .width(10.dp)
            )
            Text(
                text = nome,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = value.toString(),
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(
                modifier = Modifier
                    .width(3.dp)
            )
            Text(
                text = unit,
                fontSize = 20.sp
            )
        }

    }


}

@Composable
fun Location(

){
    Image(
        painter = painterResource(id = R.drawable.location),
        "Localização do Paciente",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(20.dp))
                ,
        contentScale = ContentScale.Crop
    )


}