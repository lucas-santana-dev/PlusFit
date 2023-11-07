package com.plusappslc.plusfit.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarHome(
    onDrawerState : () -> Unit
) {
    val empresaFantasia = "GymPlus Fit"
    CenterAlignedTopAppBar(
        title = {
            Text(
                empresaFantasia,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = { onDrawerState() }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu Lateral"
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Notificações",
                )
            }
        }
    )


}

@Preview
@Composable
fun TopAppBarHomePreview() {


}