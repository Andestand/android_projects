package ru.project.mynotesmodified.domain.usecase

import android.annotation.SuppressLint
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class GetDateTime {

    fun execute() = dataAndTime()

    @SuppressLint("NewApi")
    private fun dataAndTime(): String = LocalDateTime.now().format(
        DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
    )
}