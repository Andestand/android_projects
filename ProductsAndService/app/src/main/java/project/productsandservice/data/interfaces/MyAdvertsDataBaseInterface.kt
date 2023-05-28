package project.productsandservice.data.interfaces

import project.productsandservice.domain.models.User
import project.productsandservice.domain.models.Advert

interface MyAdvertsDataBaseInterface {

    fun addAdvert(advert: Advert): Boolean

    fun deleteAdvert(advert: Advert): Boolean

    fun isAdvert(advert: Advert): Boolean

    fun getAdverts(user: User): List<Advert>

    fun changeAdvert(advert: Advert): Boolean
}