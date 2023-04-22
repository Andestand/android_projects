package ru.project.roomexample.data.interfaces

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ru.project.roomexample.data.models.UserRoom

@Dao
interface UserDAO {

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<UserRoom>

    @Query("SELECT * FROM users WHERE username IN (:username) LIMIT 1")
    fun findByUsername(username: String): UserRoom

    @Insert
    fun insertAll(vararg user: UserRoom)

    @Delete
    fun delete(user: UserRoom)
}