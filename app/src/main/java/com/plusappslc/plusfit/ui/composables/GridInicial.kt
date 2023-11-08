package com.plusappslc.plusfit.ui.composables

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.PointOfSale
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.plusappslc.plusfit.R


@Composable
fun GridInicial() {
    LazyVerticalGrid(
        GridCells.Fixed(2),

    ) {
        item {
            CardGridInicial(
                titulo = stringResource(id = R.string.abc_mensalidades_pendentes),
                icon = Icons.Filled.NotificationsActive
            )
        }
        item {
            CardGridInicial(
                titulo = stringResource(id = R.string.abc_vender),
                icon = Icons.Filled.PointOfSale
            )
        }
        item {
            CardGridInicial(
                titulo = stringResource(id = R.string.abc_treinos_vencendo),
                icon = Icons.Filled.CalendarToday
            )
        }
        item {
            CardGridInicial(
                titulo = stringResource(id = R.string.abc_aniversariantes_do_mes),
                icon = Icons.Filled.CardGiftcard
            )
        }
        item {
            CardGridInicial(
                titulo = stringResource(id = R.string.abc_aula_experimental),
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