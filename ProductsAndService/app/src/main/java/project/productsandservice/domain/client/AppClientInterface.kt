package project.productsandservice.domain.client

import project.productsandservice.domain.models.LoginDomain
import project.productsandservice.domain.models.UserDomain
import java.util.ArrayList

interface AppClientInterface {

    fun getUser(): UserDomain

    fun addUser(user: UserDomain): Boolean

    fun isUserAuth(login: LoginDomain): Boolean

}