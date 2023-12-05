package com.plusappslc.plusfit.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.plusappslc.plusfit.data.User

@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)
}