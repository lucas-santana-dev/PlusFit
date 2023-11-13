package com.plusappslc.plusfit.ui.screens.cadastrovisitante

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.plusappslc.plusfit.R
import com.plusappslc.plusfit.ui.composables.MenuLateral
import com.plusappslc.plusfit.ui.composables.TopAppBarHome
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CadastroVisitanteScreen(navController: NavController) {
    val context = LocalContext.current

    val windowSizeClass = calculateWindowSizeClass(context as Activity)

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val drawerWidth = when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Expanded -> 350.dp
        WindowWidthSizeClass.Medium, WindowWidthSizeClass.Compact -> 300.dp
        else -> 250.dp
    }

    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var nomeAluno by remember { mutableStateOf("") }
    var sobrenomeAluno by remember { mutableStateOf("") }
    var contato by remember { mutableStateOf("") }
    var isWhatsApp by remember { mutableStateOf(false) }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.width(drawerWidth)) {
                MenuLateral(drawerState)
            }
        },
    ) {
        Scaffold(
            topBar = {
                TopAppBarHome(
                    onDrawerState = {
                        scope.launch {
                            drawerState.open()
                        }
                    },
                    title = "Cadastro de Visitante"
                )
            },
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    OutlinedTextField(
                        label = { Text(text = stringResource(id = R.string.abc_nome)) },
                        value = nomeAluno,
                        onValueChange = { newNome ->
                            nomeAluno = newNome
                        },
                        singleLine = true,
                        trailingIcon = {},
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        label = { Text(text = stringResource(id = R.string.abc_sobrenome)) },
                        value = sobrenomeAluno,
                        onValueChange = { newSobrenome ->
                            sobrenomeAluno = newSobrenome
                        },
                        singleLine = true,
                        trailingIcon = {},
                        modifier = Modifier.fillMaxWidth()

                    )
                    OutlinedTextField(
                        label = { Text(text = stringResource(id = R.string.abc_contato)) },
                        value = contato,
                        onValueChange = { newContato ->
                            contato = newContato
                        },
                        singleLine = true,
                        trailingIcon = {},
                        modifier = Modifier.fillMaxWidth()

                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Contato é Whatsapp?")
                        RadioButton(
                            selected = isWhatsApp,
                            onClick = {
                                isWhatsApp = true
                            },

                            )
                        Text("Sim")
                        Spacer(modifier = Modifier.width(16.dp))
                        RadioButton(
                            selected = !isWhatsApp,
                            onClick = {
                                isWhatsApp = false
                            },

                            )
                        Text("Não")
                    }
                    Spacer(modifier = Modifier.padding(16.dp))
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween){
                        Button(onClick = { navController.popBackStack() }) {
                            Text(text = "Cancelar")
                        }
                        Button(onClick = { /*TODO*/ }) {
                            Text(text = "Cadastrar")
                        }
                    }
                }
            }
        }
    }
}
