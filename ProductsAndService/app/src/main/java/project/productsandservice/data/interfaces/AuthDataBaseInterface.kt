package project.productsandservice.data.interfaces

import project.productsandservice.domain.models.Login
import project.productsandservice.domain.models.User

interface AuthDataBaseInterface {

    fun connectDB(username: String, password: String): Boolean

    fun sendNewUser(user: User): Boolean

    fun isUserValid(user: User): Boolean

    fun isAuthValid(login: Login): Boolean

    fun deleteUser(user: User): Boolean

    fun getUsers(): List<User>
}
