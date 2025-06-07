package com.example.engenhariadesistemas.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.engenhariadesistemas.ui.theme.Creme
import com.example.engenhariadesistemas.ui.theme.LightPurple
import com.example.engenhariadesistemas.ui.theme.LightRed
import com.example.engenhariadesistemas.R
import com.example.engenhariadesistemas.ui.theme.DarkPurple
import com.example.engenhariadesistemas.ui.theme.DarkRed
import kotlin.math.abs
import com.example.engenhariadesistemas.model.BottomMenuContent
import com.example.engenhariadesistemas.ui.components.Title
import com.example.engenhariadesistemas.ui.components.TopAppBar


@Composable
fun HomeScreen(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Title("Dados Vitais")

        Row {
            Graph(
                nome = "Heart Rate",
                icon = ImageVector.vectorResource(id = R.drawable.heart_icon),
                value = 98,
                unit = "bpm",
                lightColor = LightRed,
                darkColor = DarkRed,
                isNormal = { it in 60..100 },
                modifier = Modifier.weight(1f)
            )
            Graph(
                nome = "Respiratory Rate",
                icon = ImageVector.vectorResource(id = R.drawable.pulmonology_icon),
                value = 15,
                unit = "rpm",
                lightColor = LightPurple,
                darkColor = DarkPurple,
                isNormal = { it in 12..20 },
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(
            Modifier.height(25.dp)
        )

        Text(
            text = "Localização do Paciente",
            fontSize = 20.sp
        )
        Spacer(
            Modifier.height(25.dp)
        )
        Location()
    }
}

fun Path.waveUtil(from : Offset, to : Offset){
    quadraticTo(
        from.x,
        from.y,
        abs(from.x + to.x)/2f,
        abs(from.y + to.y) /2f
    )

}


@Composable
fun Graph(
    nome: String,
    icon : ImageVector,
    value: Int,
    unit: String,
    lightColor: Color,
    darkColor: Color,
    isNormal: (Int) -> Boolean,
    modifier: Modifier = Modifier,


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
                    .background(lightColor, RoundedCornerShape(15.dp))
            ){
                Icon(
                    imageVector = icon,
                    contentDescription = nome,
                    tint = darkColor,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
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


        Box(
            modifier = Modifier
                .background(lightColor, RoundedCornerShape(5.dp))
                .padding(3.dp)
        ){
            val label = if(isNormal(value)) "Normal" else "Anormal"

            Text(
                text = label,
                fontSize = 17.sp

            )
        }
        Spacer(
            modifier = Modifier
                .height(15.dp)
        )
        BoxWithConstraints(
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth()
                .clipToBounds()
        ) {
            val height = constraints.maxHeight
            val width = constraints.maxWidth

            val point1 = Offset(0f, height*0.3f)
            val point2 = Offset(width * 0.1f, height*0.35f)
            val point3 = Offset(width*0.4f, height*0.05f)
            val point4 = Offset(width*0.75f, height*0.7f)
            val point5 = Offset(width*1.4f, -height*1f)

            val path = Path().apply {
                //start
                moveTo(point1.x,point1.y)

                //waves
                waveUtil(point1,point2)
                waveUtil(point2,point3)
                waveUtil(point3,point4)
                waveUtil(point4,point5)

                //lines to fill a square
                lineTo(width*1f, height*1f)
                lineTo(0f, height.toFloat())

                //connect to the start
                close()

            }

            val deslocamento = 70f

            val line = Path().apply {
                val p1 = point1.copy(y = point1.y + deslocamento)
                val p2 = point2.copy(y = point2.y + deslocamento)
                val p3 = point3.copy(y = point3.y + deslocamento)
                val p4 = point4.copy(y = point4.y + deslocamento)
                val p5 = point5.copy(y = point5.y + deslocamento)

                moveTo(p1.x, p1.y)
                waveUtil(p1, p2)
                waveUtil(p2, p3)
                waveUtil(p3, p4)
                waveUtil(p4, p5)
            }

            Canvas(
                modifier = Modifier
                    .fillMaxSize()
            ){
                drawPath(
                    path = path,
                    brush = Brush.verticalGradient(
                        colors = listOf(lightColor, Color.White), // de cima para baixo
                        startY = 0f,
                        endY = size.height
                    )
                )
                drawPath(
                    path = line,
                    color = darkColor,
                    style = Stroke(width = 3f) // faz com que desenhe sem preencher o caminho dai fica somente as bordas
                )
            }


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
            .height(250.dp)
            .clip(RoundedCornerShape(20.dp))
                ,
        contentScale = ContentScale.Crop
    )


}

@Composable
fun NavigationIcon(

){

}