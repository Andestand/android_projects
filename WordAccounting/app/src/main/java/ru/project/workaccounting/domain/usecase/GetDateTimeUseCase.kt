package ru.project.workaccounting.domain.usecase

import android.annotation.SuppressLint
import ru.project.workaccounting.domain.models.DateTime
import ru.project.workaccounting.ui.reports.DateTimeConverter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class GetDateTimeUseCase {
    val f = DateTimeConverter()

    fun execute(): DateTime = get()

    @SuppressLint("NewApi")
    private fun get(): DateTime {
        val day = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("dd")
        )

        val month = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("MM")
        )

        val year = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("yyyy")
        )

        val hour = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("HH")
        )

        val minutes = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("mm")
        )

        return DateTime(
            day = day,
            idMonth = month,
            month = null,
            year = year,
            hour = hour,
            minutes = minutes
        )
    }
}