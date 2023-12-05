package com.plusappslc.plusfit.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.plusappslc.plusfit.data.Aluno
import com.plusappslc.plusfit.database.converters.Converters

@Database(
    entities = [Aluno::class],
    version = 1
)
@TypeConverters(
    Converters::class
)
abstract class PlusFitDataBase : RoomDatabase() {

    abstract fun alunoDao(): AlunoDAO
    abstract fun userDao(): UserDAO

    companion object {
        fun getDatabase(context: Context): PlusFitDataBase {
            return Room.databaseBuilder(
                context, PlusFitDataBase::class.java,
                name = "plusfit.db"
            ).build()
        }
    }


}