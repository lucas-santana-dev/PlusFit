package com.plusappslc.plusfit.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.plusappslc.plusfit.data.Aluno

@Dao
interface AlunoDAO {


    @Insert
    fun insere(aluno: Aluno)

    @Query("Select * From Aluno")
    fun buscaAll(): List<Aluno>

}