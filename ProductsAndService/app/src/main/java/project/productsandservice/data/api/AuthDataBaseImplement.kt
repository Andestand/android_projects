package project.productsandservice.data.api

import project.productsandservice.data.interfaces.AuthDataBaseInterface
import project.productsandservice.domain.models.Login
import project.productsandservice.domain.models.User

class AuthDataBaseImplement: AuthDataBaseInterface {
    override fun connectDB(username: String, password: String): Boolean {
        return false
    }

    override fun sendNewUser(user: User): Boolean {
        return false
    }

    override fun isUserValid(user: User): Boolean {
        return false
    }

    override fun isAuthValid(login: Login): Boolean {
        return false
    }

    override fun deleteUser(user: User): Boolean {
        return false
    }

    override fun getUsers(): List<User> {
        TODO("Not yet implemented")
    }

}