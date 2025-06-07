package com.example.engenhariadesistemas.ui

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.compose.rememberNavController
import com.example.engenhariadesistemas.R
import com.example.engenhariadesistemas.model.BottomMenuContent
import com.example.engenhariadesistemas.navigation.AppNavGraph
import com.example.engenhariadesistemas.navigation.Routes
import com.example.engenhariadesistemas.ui.components.BottomMenu


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = listOf(
        BottomMenuContent("Dados Rapidos", ImageVector.vectorResource(R.drawable.home_icon)),
        BottomMenuContent("Historico", ImageVector.vectorResource(R.drawable.history_icon)),
        BottomMenuContent("Informações", ImageVector.vectorResource(R.drawable.bracelet_info_incon))
    )

    Scaffold(
        bottomBar = {
            BottomMenu(
                items = items,
                lightColor = Color.White,
                darkColor = Color(0xFFE6D3B3),
            ) { index ->
                val route = when (index) {
                    0 -> Routes.HOME
                    1 -> Routes.HISTORICO
                    else -> Routes.PULSEIRA
                }
                navController.navigate(route) {
                    launchSingleTop = true
                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                    restoreState = true
                }
            }
        }
    ) { innerPadding ->
        AppNavGraph(navController = navController, innerPadding = innerPadding)
    }
}