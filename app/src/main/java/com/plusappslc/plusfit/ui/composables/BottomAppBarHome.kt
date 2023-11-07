package com.plusappslc.plusfit.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.PersonAddAlt1
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun BottomAppBarHome() {

    BottomAppBar(
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    Icons.Filled.FitnessCenter,
                    contentDescription = "Cadastrar Exercício")
            }
            IconButton(
                onClick = { /* do something */ }) {
                Icon(
                    Icons.Filled.DirectionsRun,
                    contentDescription = "Cadastrar Treino",
                )
            }
            IconButton(
                onClick = { /* do something */ }) {
                Icon(
                    Icons.Filled.PersonAddAlt1,
                    contentDescription = "Cadastrar Professor",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* do something */ },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(Icons.Filled.Add, "Cadastrar Aluno")
            }
        }
    )
}

@Preview
@Composable
fun BottomAppBarHomePreview() {
}