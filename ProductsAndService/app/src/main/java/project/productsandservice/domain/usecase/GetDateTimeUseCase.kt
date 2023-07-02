package project.productsandservice.domain.usecase

import android.annotation.SuppressLint
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class GetDateTimeUseCase {
    fun execute(): String = dataAndTime()

    @SuppressLint("NewApi")
    private fun dataAndTime(): String = LocalDateTime.now().format(
        DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
    )
}
