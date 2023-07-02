package project.productsandservice.data.dao

import androidx.room.*
import project.productsandservice.domain.models.User

@Dao
interface UserDAO {
    @Query("SELECT * FROM users")
    fun getUsers(): List<User>

    @Query("SELECT * FROM users WHERE id")
    fun getUserID(): User

    @Query("SELECT * FROM users WHERE id=:id")
    fun setUserID(id: Int): User

    @Query("SELECT * FROM users WHERE avatar=:avatar AND username=:username AND first_name=:first_name " +
            "AND last_name=:last_name AND surname=:surname AND password=:password AND email=:email " +
            "AND city=:city AND date_registration=:date_registration")
    fun getUser(
        avatar: String,
        username: String,
        first_name: String,
        last_name: String,
        surname: String,
        password: String,
        email: String,
        city: String,
        date_registration: String
    ): User


    @Query("SELECT * FROM users WHERE username=:username AND email=:email")
    fun getUsernameAndEmail(
        username: String,
        email: String,
    ): User

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: User): Long

    @Delete
    fun deleteUser(user: User)
}