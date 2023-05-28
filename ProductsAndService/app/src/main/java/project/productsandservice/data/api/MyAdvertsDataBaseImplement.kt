package project.productsandservice.data.api

import project.productsandservice.data.interfaces.MyAdvertsDataBaseInterface
import project.productsandservice.domain.models.Advert
import project.productsandservice.domain.models.User

class MyAdvertsDataBaseImplement: MyAdvertsDataBaseInterface {
    override fun addAdvert(advert: Advert): Boolean {
        return false
    }

    override fun deleteAdvert(advert: Advert): Boolean {
        return false
    }

    override fun isAdvert(advert: Advert): Boolean {
        return false
    }

    override fun getAdverts(user: User): List<Advert> {
        TODO("Not yet implemented")
    }

    override fun changeAdvert(advert: Advert): Boolean {
        return false
    }
}