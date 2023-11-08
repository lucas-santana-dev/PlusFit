package com.plusappslc.plusfit.ui.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.plusappslc.plusfit.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarHome(
    onDrawerState : () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {

        },
        navigationIcon = {
            IconButton(onClick = { onDrawerState() }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = stringResource(id = R.string.descricao_menu_lateral)
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = stringResource(id = R.string.descricao_notificacoes),
                )
            }
        }
    )


}

@Preview
@Composable
fun TopAppBarHomePreview() {


}