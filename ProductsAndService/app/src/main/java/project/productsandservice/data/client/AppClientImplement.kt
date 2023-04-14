package project.productsandservice.data.client

import project.productsandservice.data.arrays.AdvertsArray
import project.productsandservice.data.arrays.ChatsArray
import project.productsandservice.data.interfaces.AuthDataBaseInterface
import project.productsandservice.domain.client.AppClientInterface
import project.productsandservice.data.models.Login
import project.productsandservice.data.models.User
import project.productsandservice.domain.models.LoginDomain
import project.productsandservice.domain.models.UserDomain


class AppClientImplement(private val stdbi: AuthDataBaseInterface): AppClientInterface {
    override fun getUser(): UserDomain {
        return convertUser(stdbi.getUsers())
    }

    override fun addUser(user: UserDomain): Boolean {
        return stdbi.sendNewUser(user = convertUserDomain(user))
    }

    override fun isUserAuth(login: LoginDomain): Boolean {
        return stdbi.isAuthValid(login = convertLogin(login))
    }

    private fun convertUser(user: User): UserDomain {
        return UserDomain(
            avatar = user.avatar,
            username = user.username,
            first_name = user.first_name,
            last_name = user.last_name,
            surname = user.surname,
            password = user.password,
            city = user.city,
            date_registration = user.date_registration
        )
    }

    private fun convertUserDomain(user: UserDomain): User {
        return User(
            avatar = user.avatar,
            username = user.username,
            first_name = user.first_name,
            last_name = user.last_name,
            surname = user.surname,
            password = user.password,
            city = user.city,
            date_registration = user.date_registration,
            chats = ChatsArray.array,
            adverts = AdvertsArray.array
        )
    }

    private fun convertLogin(login: LoginDomain): Login {
        return Login(
            username = login.username,
            password = login.password
        )
    }
}
