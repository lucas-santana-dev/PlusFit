package com.plusappslc.plusfit.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nome: String ="",
    val email: String = "",
    val password: String = "",

)