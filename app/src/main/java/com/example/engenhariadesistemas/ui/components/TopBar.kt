package com.example.engenhariadesistemas.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.engenhariadesistemas.R


@Composable
fun TopAppBar(){

    val userIcon = ImageVector.vectorResource(id = R.drawable.accout_icon)
    val notificationIcon = ImageVector.vectorResource(id = R.drawable.notifications)
    val settingsIcon = ImageVector.vectorResource(id = R.drawable.settings)


    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
            .padding(15.dp)
    ){
        Box(
            modifier = Modifier
                .size(30.dp)
                .clickable {

                }
        ){
            Icon(
                imageVector = userIcon,
                contentDescription = "Dados do usuario",
                modifier = Modifier
                    .fillMaxSize()

            )
        }

        Row {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clickable {

                    }
            ){
                Icon(
                    imageVector = notificationIcon,
                    contentDescription = "Notificações",
                    modifier = Modifier
                        .fillMaxSize()

                )
            }

            Spacer(
                modifier = Modifier
                    .width(30.dp)
            )

            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clickable {

                    }
            ){
                Icon(
                    imageVector = settingsIcon,
                    contentDescription = "Configurações",
                    modifier = Modifier
                        .fillMaxSize()

                )
            }
        }

    }
}


@Composable
fun Title(
    title : String
){
    Text(
        text = title,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold
    )
    Spacer(
        Modifier.height(30.dp)
    )
}