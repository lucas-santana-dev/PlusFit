package com.plusappslc.plusfit.database.converters

import androidx.room.TypeConverter
import java.util.Date


class Converters {

    @TypeConverter
    fun dateToLong(valor: Date?): Long?{
        return valor?.time
    }
    @TypeConverter
    fun longToDate(valor:Long?): Date? {
        return valor?.let { Date(it) }
    }

}