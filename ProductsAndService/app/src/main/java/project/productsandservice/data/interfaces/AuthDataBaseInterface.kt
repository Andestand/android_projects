package project.productsandservice.data.interfaces

import project.productsandservice.data.models.Login
import project.productsandservice.data.models.User

interface AuthDataBaseInterface {

    fun connectDB(username: String, password: String): Boolean

    fun sendNewUser(user: User): Boolean

    fun isUserValid(user: User): Boolean

    fun isAuthValid(login: Login): Boolean

    fun deleteUser(user: User): Boolean

    fun getUsers(): User
}
