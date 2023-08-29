package ru.project.workaccounting.domain.usecase

import android.annotation.SuppressLint
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class GetDateTimeUseCase {

    fun execute(): String = get()

    @SuppressLint("NewApi")
    private fun get(): String = LocalDateTime.now().format(
        DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
    )
}