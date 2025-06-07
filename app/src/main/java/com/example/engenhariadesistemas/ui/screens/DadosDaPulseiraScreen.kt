package com.example.engenhariadesistemas.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.engenhariadesistemas.R
import com.example.engenhariadesistemas.ui.components.Title
import com.example.engenhariadesistemas.ui.theme.Green
import java.util.Locale

@Composable
fun DadosDaPulseiraScreen(innerPadding: PaddingValues){
    Column (
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .padding(15.dp)
    ){
        Title("Status da pulseira")


        Row(
            modifier = Modifier
                .fillMaxWidth()
        ){
            BatteryInfo(
                23,
                modifier = Modifier
                    .weight(0.5f),
            )

            WifiInfo(
                2.4f,
                "RESIDÊNCIA",
                modifier = Modifier
                    .weight(0.5f)
            )
            InteractionInfo(
                25,
                modifier = Modifier
                    .weight(1f)
            )


        }

    }
}

@Composable
fun InteractionInfo(
    lastInteraction: Int,
    modifier: Modifier = Modifier,
){

    val interactionIcon = ImageVector.vectorResource(R.drawable.calm_face)

    Box(
        modifier = modifier
            .padding(5.dp)
            .height(70.dp)
            .background(color = Color.White, shape = RoundedCornerShape(10.dp))

    ){
        Row(
            modifier = Modifier
                .fillMaxSize()
        ){
            Icon(
                imageVector = interactionIcon,
                contentDescription = "Icone de Bateria",
                modifier = Modifier
                    .weight(0.5f)
                    .fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = "Última interação com a pulseira",
                    fontSize = 15.sp,
                )
                Text(
                    text = "${lastInteraction}min",
                    color = Green,
                    fontSize = 15.sp
                )

            }
        }
    }

}


@Composable
fun WifiInfo(
    wifiFrequency: Float,
    wifiType: String,
    modifier: Modifier = Modifier
){
    val wifiIcon = ImageVector.vectorResource(R.drawable.wifi)

    Box(
        modifier = modifier
            .padding(5.dp)
            .height(70.dp)
            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
    ){

        Column (
            modifier = Modifier
                .fillMaxSize()
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ){
                Icon(
                    imageVector = wifiIcon,
                    contentDescription = "Icone de Bateria",
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                )
                Text(
                    text = String.format(Locale.US, "%.1fGHz", wifiFrequency),
                    fontSize = 15.sp,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                )

            }

            Text(
                text = wifiType,
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

        }

    }

}

@Composable
fun BatteryInfo(
    batteryLevel : Int,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .padding(5.dp)
            .height(70.dp)
            .background(color = Color.White, shape = RoundedCornerShape(10.dp))

    ){
        val batteryIcon = when (batteryLevel) {
            0 -> ImageVector.vectorResource(id = R.drawable.battery_0)
            in 1..16 -> ImageVector.vectorResource(id = R.drawable.battery_1)
            in 17..33 -> ImageVector.vectorResource(id = R.drawable.battery_2)
            in 34..50 -> ImageVector.vectorResource(id = R.drawable.battery_3)
            in 51..66 -> ImageVector.vectorResource(id = R.drawable.battery_4)
            in 67..83 -> ImageVector.vectorResource(id = R.drawable.battery_5)
            in 84..99 -> ImageVector.vectorResource(id = R.drawable.battery_6)
            100 -> ImageVector.vectorResource(id = R.drawable.battery_full)
            else -> ImageVector.vectorResource(id = R.drawable.battery_alert) // fallback
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
        ){
            Icon(
                imageVector = batteryIcon,
                contentDescription = "Icone de Bateria",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            )
            Text(
                text = "$batteryLevel%",
                fontSize = 20.sp,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )

        }



    }
}