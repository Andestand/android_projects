package project.productsandservice.data.api

import project.productsandservice.data.interfaces.AuthDataBaseInterface
import project.productsandservice.data.models.Login
import project.productsandservice.data.models.User
import java.sql.DriverManager

class AuthDataBaseImplement: AuthDataBaseInterface {
    override fun connectDB(username: String, password: String): Boolean {
        DriverManager.getConnection("", username, password)
        return true
    }

    override fun sendNewUser(user: User): Boolean {
        TODO("Not yet implemented")
    }

    override fun isUserValid(user: User): Boolean {
        TODO("Not yet implemented")
    }

    override fun isAuthValid(login: Login): Boolean {
        TODO("Not yet implemented")
    }

    override fun deleteUser(user: User): Boolean {
        TODO("Not yet implemented")
    }

    override fun getUsers(): User {
        TODO("Not yet implemented")
    }

}