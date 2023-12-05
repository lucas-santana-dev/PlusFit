package com.plusappslc.plusfit.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(

    @PrimaryKey
    val id: String,
    val nome: String ="",
    val email: String = "",

)