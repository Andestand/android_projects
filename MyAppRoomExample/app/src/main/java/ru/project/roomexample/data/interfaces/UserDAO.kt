package ru.project.roomexample.data.interfaces

import androidx.room.*
import ru.project.roomexample.data.models.UserRoom

@Dao
interface UserDAO {
    @Query("SELECT * FROM users")
    fun getAllUsers(): List<UserRoom>

    @Query("SELECT * FROM users WHERE username=:username")
    fun findByUsername(username: String): UserRoom

    @Query("SELECT * FROM users WHERE password=:password")
    fun findByPassword(password: String): UserRoom

    @Query("SELECT * FROM users WHERE username=:username AND password=:password")
    fun isUser(username: String, password: String): UserRoom

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: UserRoom): Long

    @Update(entity = UserRoom::class)
    fun changeUser(user: UserRoom)

    @Delete
    fun delete(vararg user: UserRoom)
}