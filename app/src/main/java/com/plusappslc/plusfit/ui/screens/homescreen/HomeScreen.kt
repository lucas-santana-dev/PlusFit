package com.plusappslc.plusfit.ui.screens.homescreen

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.plusappslc.plusfit.R
import com.plusappslc.plusfit.ui.composables.BottomAppBarHome
import com.plusappslc.plusfit.ui.composables.GridInicial
import com.plusappslc.plusfit.ui.composables.MenuLateral
import com.plusappslc.plusfit.ui.composables.TopAppBarHome
import kotlinx.coroutines.launch

private  const val TAG = "HomeScreen"
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val context = LocalContext.current
    val windowSizeClass = calculateWindowSizeClass(context as Activity)
    val drawerWidth = when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Expanded -> 350.dp
        WindowWidthSizeClass.Medium, WindowWidthSizeClass.Compact -> 300.dp
        else -> 250.dp
    }
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.width(drawerWidth)) {
                MenuLateral(drawerState)
            }
        }) {
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBarHome(
                    onDrawerState = {
                        scope.launch {
                            drawerState.open()
                        }
                    },
                    title = null
                )
            },
            bottomBar = {
                BottomAppBarHome(navController)
            },
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = stringResource(id = R.string.abc_bem_vindo_de_volta),
                        fontSize = 24.sp
                    )
                    Text(
                        text = "Lucas",
                        fontWeight = FontWeight.Bold,
                        fontSize = 36.sp
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Divider()
                }
                GridInicial()
            }
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {

}