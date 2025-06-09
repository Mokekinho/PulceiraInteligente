package com.example.engenhariadesistemas.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.engenhariadesistemas.R
import androidx.compose.ui.text.font.FontWeight

@Composable
fun BemEstarScreen(innerPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Bem-Estar",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Sono", fontSize = 19.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        InfoCard(
            icon = R.drawable.sleep,
            title = "Qualidade do sono",
            subtitle = "Monitoramento do sono",
            buttonText = "Ver Detalhes"
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Atividade Física", fontSize = 19.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        InfoCard(
            icon = R.drawable.walk,
            title = "Passos diários",
            subtitle = "Tempo de caminhada",
            buttonText = "Ver Atividades"
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Dicas de Saúde", fontSize = 19.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        InfoCard(
            icon = R.drawable.coracao,
            title = "Dicas para cuidadores"
        )
    }
}

@Composable
fun InfoCard(
    icon: Int,
    title: String,
    subtitle: String? = null,
    buttonText: String? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color(0xFFF7F7F7), shape = RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                if (!subtitle.isNullOrEmpty()) {
                    Text(
                        text = subtitle,
                        fontSize = 13.sp,
                        color = Color.Gray
                    )
                }
            }
        }

        if (!buttonText.isNullOrEmpty()) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .border(1.dp, Color.LightGray, shape = RoundedCornerShape(8.dp))
                    .clickable { /* ação */ }
                    .padding(horizontal = 10.dp, vertical = 6.dp)
            ) {
                Text(text = buttonText, fontSize = 13.sp)
            }
        }
    }
}
