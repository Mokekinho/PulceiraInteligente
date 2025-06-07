package com.example.engenhariadesistemas.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.engenhariadesistemas.model.BottomMenuContent

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    darkColor: Color,
    lightColor: Color,
    initialSelectedItemId: Int = 0,
    onItemClick: (Int) -> Unit
) {
    var selectedItemId by remember { mutableIntStateOf(initialSelectedItemId) }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(lightColor)
            .padding(15.dp)
    ) {
        items.forEachIndexed { id, item ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(7.dp))
                        .clickable {
                            selectedItemId = id
                            onItemClick(id)
                        }
                        .background(if (id == selectedItemId) darkColor else Color.Transparent)
                        .padding(10.dp)
                ) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = Color.Black,
                        modifier = Modifier.size(30.dp)
                    )
                }
                Text(
                    text = item.title,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (id == selectedItemId) Color.Black else Color.LightGray
                )
            }
        }
    }
}


/**
@Composable
fun BottomMenu(
    items : List<BottomMenuContent>,
    modifier : Modifier = Modifier,
    darkColor: Color,
    lightColor: Color,
    initialSelectedItemId: Int = 0
){
    var selectedItemId by remember {
        mutableIntStateOf(
            initialSelectedItemId
        )
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(15.dp)
    ){
        items.forEachIndexed{ id, item ->
            BottomMenuItem(
                item = item,
                isSelected = id == selectedItemId,
                lightColor = lightColor,
                darkColor = darkColor
            ) {
                selectedItemId = id
            }

        }
    }


}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    darkColor: Color,
    lightColor: Color,
    onItemClick: () -> Unit
){



    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(7.dp))
                .clickable {
                    onItemClick()
                }
                .background(if(isSelected) darkColor else Color.Transparent)
                .padding(10.dp)

        ){
            Icon(
                imageVector = item.icon,
                contentDescription = item.title,
                tint = Color.Black,
                modifier = Modifier
                    .size(30.dp)
            )
        }
        Text(
            text = item.title,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = if(isSelected) Color.Black else Color.LightGray
        )
    }

}
 */
