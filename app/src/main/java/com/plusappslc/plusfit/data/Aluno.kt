package com.plusappslc.plusfit.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Aluno (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nome: String = "",
    val Sobrenome: String? = "",
    val dataNascimento: Date? = null,
    val rg: String? = "",
    val cfp: String? = "",
    val dataInicio: Date = Date(),
    val status: Boolean = true,
)