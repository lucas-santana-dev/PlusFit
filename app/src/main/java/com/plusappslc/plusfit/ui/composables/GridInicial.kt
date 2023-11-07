package com.plusappslc.plusfit.ui.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.PointOfSale
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun GridInicial() {
    LazyVerticalGrid(
        GridCells.Fixed(2),

    ) {
        item {
            CardGridInicial(
                titulo = "Mensalidades Pendentes",
                icon = Icons.Filled.NotificationsActive
            )
        }
        item {
            CardGridInicial(
                titulo = "Vender",
                icon = Icons.Filled.PointOfSale
            )
        }
        item {
            CardGridInicial(
                titulo = "Treinos Vencendo",
                icon = Icons.Filled.CalendarToday
            )
        }
        item {
            CardGridInicial(
                titulo = "Aniversariantes do Mês",
                icon = Icons.Filled.CardGiftcard
            )
        }
        item {
            CardGridInicial(
                titulo = "Aula Experimental para Hoje",
                icon = Icons.Filled.ListAlt
            )
        }
    }
}

@Preview
@Composable
fun  GridInicialPreview(){
    GridInicial()
}