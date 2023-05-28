package project.productsandservice.domain.usecase

import project.productsandservice.data.interfaces.MyAdvertsDataBaseInterface
import project.productsandservice.domain.models.*

class GetAdvertsUseCase(private val madbi: MyAdvertsDataBaseInterface) {
    fun execute(user: User): List<Advert> = madbi.getAdverts(user = user)
}
