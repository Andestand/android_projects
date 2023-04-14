package project.productsandservice.domain.usecase

import project.productsandservice.domain.client.AppClientInterface
import project.productsandservice.domain.models.LoginDomain

class AuthUseCase(private val aci: AppClientInterface) {

    fun execute(login: LoginDomain): Boolean {
        return aci.isUserAuth(login = login)
    }
}