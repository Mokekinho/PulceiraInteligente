package com.example.engenhariadesistemas.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.engenhariadesistemas.ui.screens.BemEstarScreen
import com.example.engenhariadesistemas.ui.screens.ConectarPulseiraScreen
import com.example.engenhariadesistemas.ui.screens.DadosDaPulseiraScreen
import com.example.engenhariadesistemas.ui.screens.HistoricoScreen
import com.example.engenhariadesistemas.ui.screens.HomeScreen


@Composable
fun AppNavGraph(
    navController: NavHostController,
    innerPadding: PaddingValues,
) {
    NavHost(navController = navController, startDestination = "home") {
        composable(Routes.HOME) { HomeScreen(innerPadding) }
        composable(Routes.HISTORICO) { HistoricoScreen(innerPadding)}
        composable(Routes.PULSEIRA) { DadosDaPulseiraScreen(innerPadding,navController) }
        composable(Routes.BEM_ESTAR){ BemEstarScreen(innerPadding)}
        composable(Routes.CONECTAR_PULSEIRA) { ConectarPulseiraScreen(navController)}
    }
}