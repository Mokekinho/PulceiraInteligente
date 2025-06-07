package com.example.engenhariadesistemas.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.engenhariadesistemas.ui.components.TopAppBar
import com.example.engenhariadesistemas.ui.theme.DarkRed
import com.example.engenhariadesistemas.ui.theme.Green

@Composable
fun HistoricoScreen(innerPadding: PaddingValues){
    Column (
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .padding(15.dp)
    ) {
        TopAppBar("Histórico")

        Historico(
            title = "Hoje",
            action = "ver outros dias",
            description = "Média de batimentos cardíacos em repouso",
            value = 59,
            unit = "bpm",
            isNormal = {
                it in 60..100
            }
        )

        Spacer(
            Modifier.height(25.dp)
        )

        Historico(
            title = "Esta semana",
            action = "ver outras semanas",
            description = "Média de batimentos cardíacos em repouso",
            value = 67,
            unit = "bpm",
            isNormal = {
                it in 60..100
            }
        )

        Spacer(
            Modifier.height(25.dp)
        )

        Text(
            text = "Este mês",
            fontSize = 20.sp
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(Color.White, RoundedCornerShape(10.dp))
        )
    }
}

@Composable
fun Historico(
    title: String,
    action: String,
    description: String,
    value : Int,
    unit : String,
    isNormal: (Int) -> Boolean,
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
            ,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = title,
                fontSize = 20.sp
            )
            Text(
                text = action,
                fontSize = 15.sp,
                color = Color.Blue,
                modifier = Modifier
                    .clickable {
                        //abrir tela que mostra mais coisas
                    }
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(10.dp))
            ,
        ){
            Column() {
                Text(
                    description,
                    fontSize = 20.sp,
                )

                Spacer(
                    Modifier.height(25.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                    ,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ){
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
                    val color : Color
                    val text : String

                    if(isNormal(value)){
                        color = Green
                        text = "normal"
                    }
                    else{
                        color = DarkRed
                        text = "anormal"
                    }

                    Text(
                        text = "Frequencia cardiaca " + text,
                        color = color,
                        fontSize = 17.sp,
                    )

                }
            }

        }
    }


}