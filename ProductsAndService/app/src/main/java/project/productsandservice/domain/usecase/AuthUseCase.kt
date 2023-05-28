package project.productsandservice.domain.usecase

import project.productsandservice.data.interfaces.AuthDataBaseInterface
import project.productsandservice.domain.models.Login

class AuthUseCase(private val aci: AuthDataBaseInterface) {

    fun execute(login: Login): Boolean = aci.isAuthValid(login = login)
}