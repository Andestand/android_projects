package project.productsandservice.domain.usecase

import project.productsandservice.data.interfaces.AuthDataBaseInterface
import project.productsandservice.domain.models.User

class RegisterUseCase(private val aci: AuthDataBaseInterface) {

    fun execute(user: User): Boolean = aci.sendNewUser(user = user)
}