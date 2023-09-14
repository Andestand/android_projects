package ru.project.workaccounting.ui.reports

import androidx.room.TypeConverter
import ru.project.workaccounting.domain.models.DateTime
import ru.project.workaccounting.domain.models.Work

class DateTimeConverter {
    @TypeConverter
    fun fromDateTime(dt: DateTime): String {
        return "${dt.day}.${dt.idMonth}.${dt.year} ${dt.hour}:${dt.minutes}"
    }

    @TypeConverter
    fun toDateTime(dt: String): DateTime {
        val (day, idMonth, year, hour, minutes) = dt.split(".", " ", ":")

        return DateTime(
            day = day,
            idMonth = idMonth,
            month = null,
            year = year,
            hour = hour,
            minutes = minutes
        )
    }
}