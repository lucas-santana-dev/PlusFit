package com.plusappslc.plusfit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plusappslc.plusfit.ui.screens.cadastrousuario.CadastroUsuarioSceen
import com.plusappslc.plusfit.ui.screens.cadastrovisitante.CadastroVisitanteScreen
import com.plusappslc.plusfit.ui.screens.homescreen.HomeScreen
import com.plusappslc.plusfit.ui.screens.loginscreen.LoginScreen

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
        composable(Destinations.CadastroVisitanteScreen.route){
            CadastroUsuarioSceen(navController = navController)
        }
    }
}