package com.plusappslc.plusfit.ui.composables

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuLateral(drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    var selectedItem  by remember { mutableIntStateOf(0) }
    NavigationDrawerItem(
        label = { Text(text = "Inicio") },
        selected =selectedItem == 1 ,
        onClick = {
            selectedItem = 1
            scope.launch {
                drawerState.close()
            }
        },
        icon = {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Inicio",
                modifier = Modifier.size(20.dp)
            )
        }
    )
    NavigationDrawerItem(
        label = { Text(text = "Mensalidades") },
        selected =selectedItem == 2 ,
        onClick = {
            selectedItem = 2
            scope.launch {
                drawerState.close()
            }
        },
        icon = {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Mensalidades",
                modifier = Modifier.size(20.dp)
            )
        }
    )
}