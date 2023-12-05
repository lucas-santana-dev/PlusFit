package com.plusappslc.plusfit.ui.screens.cadastrousuario

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.plusappslc.plusfit.R
import com.plusappslc.plusfit.data.User
import com.plusappslc.plusfit.database.PlusFitDataBase
import com.plusappslc.plusfit.ui.theme.PlusFitTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CadastroUsuarioSceen(navController: NavController) {
    val context = LocalContext.current
    val viewmodel = koinViewModel<CadastroUsuarioViewModel>()
    val lifecycleOwner = LocalLifecycleOwner.current
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val userDao = PlusFitDataBase.getDatabase(context).userDao()
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 16.dp)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Icon(
                    imageVector = Icons.Filled.FitnessCenter,
                    contentDescription = stringResource(id = R.string.descricao_icone_logotipo),
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(75.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.abc_logo_text_plus),
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = stringResource(id = R.string.abc_logo_text_fit),
                        fontWeight = FontWeight.Light,
                        fontSize = 32.sp
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                Text(
                    text = stringResource(id = R.string.abc_mensagem_tela_cadastro),
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )


            }
            Spacer(modifier = Modifier.height(16.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 16.dp
                    )
            ) {
                OutlinedTextField(
                    label = { Text(text = stringResource(id = R.string.abc_email)) },
                    value = viewmodel.email.value,
                    onValueChange = { newEmail ->
                        // Atualiza o valor do e-mail
                        viewmodel.email.value = newEmail
                        if (viewmodel.isValidEmail(newEmail)) {
                            viewmodel.emailError.value = false
                        } else {
                            viewmodel.emailError.value = true
                        }
                    },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Email, contentDescription = stringResource(
                                id = R.string.descricao_campo_email
                            )
                        )
                    },
                    trailingIcon = {},
                    isError = viewmodel.emailError.value,
                    visualTransformation = VisualTransformation.None,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    label = { Text(text = stringResource(id = R.string.abc_senha)) },
                    value = viewmodel.password.value,
                    onValueChange = { newPassword ->
                        viewmodel.password.value = newPassword
                    },
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Password,
                            contentDescription = stringResource(
                                id = R.string.descricao_campo_senha
                            )
                        )
                    },

                    visualTransformation = if (viewmodel.passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = {
                            viewmodel.passwordVisible.value = !viewmodel.passwordVisible.value
                        }) {
                            if (!viewmodel.passwordVisible.value) {
                                Icon(
                                    imageVector = Icons.Filled.VisibilityOff,
                                    contentDescription = stringResource(id = R.string.descricao_campo_senha_ocultada)
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Filled.Visibility,
                                    contentDescription = stringResource(id = R.string.descricao_campo_senha_visivel)
                                )
                            }

                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    label = { Text(text = stringResource(id = R.string.abc_confirme_senha)) },
                    value = viewmodel.passwordConfirmation.value,
                    onValueChange = { newPassword ->
                        viewmodel.passwordConfirmation.value = newPassword
                        if (viewmodel.passwordConfirmation.value != viewmodel.password.value) {
                            viewmodel.passwordError.value = true
                        } else {
                            viewmodel.passwordError.value = false
                        }
                    },
                    isError = viewmodel.passwordError.value,
                    singleLine = true,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Password,
                            contentDescription = stringResource(
                                id = R.string.descricao_campo_senha
                            )
                        )
                    },
                    visualTransformation = if (viewmodel.passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = {
                            viewmodel.passwordVisible.value = !viewmodel.passwordVisible.value
                        }) {
                            if (!viewmodel.passwordVisible.value) {
                                Icon(
                                    imageVector = Icons.Filled.VisibilityOff,
                                    contentDescription = stringResource(id = R.string.descricao_campo_senha_ocultada)
                                )
                            } else {
                                Icon(
                                    imageVector = Icons.Filled.Visibility,
                                    contentDescription = stringResource(id = R.string.descricao_campo_senha_visivel)
                                )
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(10.dp))
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewmodel.cadastrarUsuario().observe(lifecycleOwner) {
                        it?.let { recurso ->
                            if (recurso.dado) {

                                navController.popBackStack()
                                scope.launch {
                                    snackbarHostState
                                        .showSnackbar(
                                            message = "Cadastro Realizado com sucesso",
                                            actionLabel = "Ok!",
                                            duration = SnackbarDuration.Short
                                        )
                                }
                            } else {
                                val mensagemError = recurso.erro
                                    ?: "Ocorreu um erro ao tentar realizar seu registro tente novamente"
                                scope.launch {
                                    snackbarHostState
                                        .showSnackbar(
                                            message = mensagemError,
                                            actionLabel = "Ok!",
                                            duration = SnackbarDuration.Short
                                        )
                                }
                            }
                        }
                    }
                }
            ) {
                Text(text = stringResource(id = R.string.abc_cadastrar))
            }

        }
    }

}
