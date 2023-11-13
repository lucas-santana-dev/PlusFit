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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.plusappslc.plusfit.repository.FirebaseAuthRepository

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CadastroUsuarioSceen(navController: NavController) {

    val viewmodel = CadastroUsuarioViewModel()

    Scaffold {
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
                        IconButton(onClick = { viewmodel.passwordVisible.value = !viewmodel.passwordVisible.value }) {
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
                    }
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
                        IconButton(onClick = { viewmodel.passwordVisible.value = !viewmodel.passwordVisible.value }) {
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
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewmodel.cadastrarUsuario()
                }
            ) {
                Text(text = stringResource(id = R.string.abc_cadastrar))
            }

        }
    }

}
