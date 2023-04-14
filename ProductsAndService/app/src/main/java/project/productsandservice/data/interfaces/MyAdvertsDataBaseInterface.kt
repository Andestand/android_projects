package project.productsandservice.data.interfaces

import project.productsandservice.data.models.User
import project.productsandservice.domain.models.Advert

interface MyAdvertsDataBaseInterface {

    fun addAdvert(advert: Advert): Boolean

    fun deleteAdvert(advert: Advert): Boolean

    fun isAdvert(advert: Advert): Boolean

    fun getAdverts(user: User): List<Advert>
}