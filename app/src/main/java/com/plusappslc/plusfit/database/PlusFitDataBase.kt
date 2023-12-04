package com.plusappslc.plusfit.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.plusappslc.plusfit.data.Aluno

@Database(
    entities = [Aluno::class],
    version = 1
)
abstract class PlusFitDataBase : RoomDatabase() {

    abstract fun alunoDao(): AlunoDAO

    fun getDatabase(context: Context): PlusFitDataBase {
        return Room.databaseBuilder(
            context, PlusFitDataBase::class.java,
            name = "plusfit.db"
        ).build()
    }


}