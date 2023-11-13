package com.plusappslc.plusfit.navigation

sealed class Destinations(val route: String) {

    object  HomeScreen : Destinations("home_screen")
    object  LoginScreen : Destinations("login_screen")
    object  CadastroVisitanteScreen : Destinations("cadastro_visitante_screen")
    object  CadastroUsuarioSCreen : Destinations("cadastro_usuario_screen")
}