package project.productsandservice.domain.usecase

import project.productsandservice.data.interfaces.MyAdvertsDataBaseInterface
import project.productsandservice.domain.models.Advert

class AddAdvertUseCase(private val madbi: MyAdvertsDataBaseInterface) {

    fun execute(advert: Advert): Boolean = madbi.addAdvert(advert = advert)
}
