package project.productsandservice.data.arrays

import project.productsandservice.domain.models.Chat

object ChatsArray {
    val array = listOf(
        Chat(
            id = 1,
            users = "Dostoevsky",
            messages = MessagesArray.array.toList()
        )
    )
}
