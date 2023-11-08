package com.plusappslc.plusfit.ui.screens

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
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen() {

    var passwordVisible by remember { mutableStateOf(false) }
    var password by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }


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
                    contentDescription = "Icone de Centro Fitness",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(75.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Plus",
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = "Fit",
                        fontWeight = FontWeight.Light,
                        fontSize = 32.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                OutlinedTextField(
                    label = { Text(text = "Email:") },
                    value = email,
                    onValueChange = {newEmail->
                        email = newEmail
                    },
                    singleLine = true,
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Email, contentDescription = "Email")
                    },
                    trailingIcon = {}
                )
                Spacer(modifier = Modifier.height(10.dp))
                OutlinedTextField(
                    label = { Text(text = "Senha:") },
                    value = password,
                    onValueChange = {newPassword->
                        password = newPassword
                    },
                    singleLine = true,
                    leadingIcon = {
                        Icon(imageVector = Icons.Filled.Password, contentDescription = "Senha")
                    },
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible =!passwordVisible }) {
                          if(!passwordVisible){
                              Icon(imageVector = Icons.Filled.VisibilityOff, contentDescription = "Senha ocultada" )
                          }else(
                                  Icon(imageVector = Icons.Filled.Visibility, contentDescription = "Senha Visivel" )
                          )
                        }
                    }
                )
                Spacer(modifier = Modifier.height(5.dp))
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Não consegue acessar?")
                    }
                }
            }
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Entrar")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Ainda não tem uma conta?")
                TextButton(
                    onClick = { /*TODO*/ },
                ) {
                    Text(text = "Registre-se agora!")
                }
            }


        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}