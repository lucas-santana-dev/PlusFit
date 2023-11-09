package com.plusappslc.plusfit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plusappslc.plusfit.ui.screens.CadastroVisitanteScreen
import com.plusappslc.plusfit.ui.screens.HomeScreen
import com.plusappslc.plusfit.ui.screens.LoginScreen

@Composable
fun NavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destinations.LoginScreen.route
    ) {
        composable(Destinations.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(Destinations.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

        composable(Destinations.CadastroVisitanteScreen.route){
            CadastroVisitanteScreen(navController = navController)
        }
    }
}