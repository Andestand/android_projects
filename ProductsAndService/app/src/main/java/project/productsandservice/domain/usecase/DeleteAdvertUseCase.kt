package project.productsandservice.domain.usecase

import project.productsandservice.data.interfaces.MyAdvertsDataBaseInterface
import project.productsandservice.domain.models.Advert

class DeleteAdvertUseCase(private val madbi: MyAdvertsDataBaseInterface) {
    fun execute(advert: Advert): Boolean = madbi.deleteAdvert(advert = advert)

}