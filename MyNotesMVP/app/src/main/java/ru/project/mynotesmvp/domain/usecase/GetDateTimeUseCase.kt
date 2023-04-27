package ru.project.mynotesmvp.domain.usecase

import android.annotation.SuppressLint
import android.os.Build
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class GetDateTimeUseCase {

    fun execute(): String {
        return dataAndTime()
    }

    @SuppressLint("NewApi")
    private fun dataAndTime(): String {
        val dateTime = LocalDateTime.now()
        val format = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
        return dateTime.format(format)
    }
}