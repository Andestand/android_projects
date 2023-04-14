package project.productsandservice.domain.usecase

import project.productsandservice.domain.client.AppClientInterface
import project.productsandservice.domain.models.UserDomain

class RegisterUseCase(private val aci: AppClientInterface) {

    fun execute(user: UserDomain): Boolean {
        return aci.addUser(user = user)
    }
}