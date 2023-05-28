package project.productsandservice.data.arrays

import project.productsandservice.domain.models.*

object AdvertsArray {
    val array = listOf(
        Advert(
            title = "Полина Бушуева",
            description = "Отдаю даром в сексуальное рабство",
            price = "0$",
            media_file = ImagesArray.array_advert_2,
            date_added = "24.5.2023 4:52",
            author_advert = UsersArray.array[1],
            isStatus = Status.Active
        ),
        Advert(
            title = "Вилена Галиуллина",
            description = "подарю для сексуального рабства",
            price = "0$",
            media_file = ImagesArray.array_advert_3,
            date_added = "24.5.2023 5:17",
            author_advert = UsersArray.array[0],
            isStatus = Status.Active
        )
    )
}