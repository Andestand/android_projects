package project.productsandservice.data.arrays

import project.productsandservice.R
import project.productsandservice.domain.models.User

object UsersArray {
    val array = listOf(
        User(
            id = 1,
            avatar = R.drawable.ic_launcher_background.toString(),
            username = "Dostoevsky",
            first_name = "Андрей",
            last_name = "Яровой",
            surname = "Фёдорович",
            password = "0000",
            email = "bastionak@gmail.com",
            city = "Москва",
            date_registration = "2015",
        ),
        User(
            id = 2,
            avatar = R.drawable.ic_launcher_background.toString(),
            username = "erinsterg",
            first_name = "Даниил",
            last_name = "Соколов",
            surname = "Данилович",
            email = "bastionak@gmail.com",
            password = "666",
            city = "Москва",
            date_registration = "2020"
        )
    )
}
