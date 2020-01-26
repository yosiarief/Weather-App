package com.yosiarief.hipe.data.room

import androidx.room.TypeConverter

class Convert {
    @TypeConverter
    fun stringAsStringList(strings: String?): List<String> {
        val list = mutableListOf<String>()
        strings
            ?.split(",")
            ?.forEach {
                list.add(it)
            }

        return list
    }

    @TypeConverter
    fun stringListAsString(strings: List<String>?): String {
        var result = ""
        strings?.forEach { element ->
            result += "$element,"
        }
        return result.removeSuffix(",")
    }
}