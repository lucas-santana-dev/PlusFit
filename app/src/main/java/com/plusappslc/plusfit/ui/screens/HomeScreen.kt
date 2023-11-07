package com.plusappslc.plusfit.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plusappslc.plusfit.ui.composables.BottomAppBarHome
import com.plusappslc.plusfit.ui.composables.GridInicial
import com.plusappslc.plusfit.ui.composables.TopAppBarHome


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            TopAppBarHome()
        },
        bottomBar = {
            BottomAppBarHome()
        },

        )
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
        ) {
            Column(modifier = Modifier.padding(10.dp))
            {
                Text(
                    text = "Bem vindo de volta",
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





@Preview
@Composable
fun HomeScreenPreview() {

}