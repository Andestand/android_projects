package project.productsandservice.data.arrays

import project.productsandservice.domain.models.Message

object MessagesArray {
    val array = arrayOf(
        Message(
            message = "Привет, как дела?",
            datetime = "10:00",
            type = 0
        ),
        Message(
            message = "Привет, нормально а у тебя?",
            datetime = "10:00",
            type = 1
        ),
        Message(
            message = "Тоже",
            datetime = "10:00",
            type = 0
        ),
        Message(
            message = "Понятно",
            datetime = "10:00",
            type = 1
        ),
        Message(
            message = "Что делаешь?",
            datetime = "10:00",
            type = 0
        ),
        Message(
            message = "Ничего, а ты?",
            datetime = "10:00",
            type = 1
        ),
        Message(
            message = "За компом сижу",
            datetime = "10:00",
            type = 0
        ),
        Message(
            message = "Понятно",
            datetime = "10:00",
            type = 1
        ),
    )
}