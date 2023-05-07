package ru.project.roomexample.data.interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ru.project.roomexample.data.models.UserRoom

@Dao
interface UserDAO {
    @Query("SELECT * FROM users")
    fun getAllUsers(): List<UserRoom>

    @Query("SELECT * FROM users WHERE username=:username")
    fun findByUsername(username: String): UserRoom

    @Query("SELECT * FROM users WHERE username=:username AND password=:password")
    fun isUser(username: String, password: String): UserRoom

    @Insert
    fun addUser(vararg user: UserRoom)

    @Update(entity = UserRoom::class)
    fun changeUser(user: UserRoom)

    @Delete
    fun delete(vararg user: UserRoom)
}