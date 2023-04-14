package project.productsandservice.data.arrays

import project.productsandservice.domain.models.Advert

object AdvertsArray {
    val array = listOf(
        Advert(
            title = "объявленине 1",
            description = "объявленине 1",
            price = "0$",
            media_file = ImagesArray.array_advert_2,
            date_added = "?????",
            author_advert = "Dostoevsky"
        )
    )
}