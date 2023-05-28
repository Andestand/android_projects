package project.productsandservice.domain.usecase

import project.productsandservice.data.interfaces.MyAdvertsDataBaseInterface
import project.productsandservice.domain.models.Advert

class ChangeAdvertUseCase(private val madbi: MyAdvertsDataBaseInterface) {

    fun execute(advert: Advert): Boolean = madbi.changeAdvert(advert = advert)
}