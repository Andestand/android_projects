package project.productsandservice.data.arrays

import project.productsandservice.R
import project.productsandservice.data.models.User

object UsersArray {
    val array = listOf(
        User(
            avatar = R.drawable.ic_launcher_background,
            username = "Dostoevsky",
            first_name = "Андрей",
            last_name = "Яровой",
            surname = "Фёдорович",
            password = "0000",
            city = "Москва",
            date_registration = "2015",
            chats = ChatsArray.array,
            adverts = AdvertsArray.array
        ),
        User(
            avatar = R.drawable.ic_launcher_background,
            username = "erinsterg",
            first_name = "Даниил",
            last_name = "Соколов",
            surname = "Данилович",
            password = "666",
            city = "Москва",
            date_registration = "2020",
            chats = ChatsArray.array,
            adverts = AdvertsArray.array
        )
    )
}
