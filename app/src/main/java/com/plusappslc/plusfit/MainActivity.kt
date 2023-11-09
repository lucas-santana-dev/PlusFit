package com.plusappslc.plusfit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.plusappslc.plusfit.navigation.NavHost
import com.plusappslc.plusfit.ui.screens.LoginScreen
import com.plusappslc.plusfit.ui.theme.PlusFitTheme

/**
 * MainActivity é a atividade principal do aplicativo.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            /**
             * Configuração do conteúdo da atividade usando Jetpack Compose.
             */
            PlusFitTheme {
                // Uma superfície usando a cor de fundo do tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    NavHost()
                }
            }
        }
    }
}
