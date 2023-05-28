package project.productsandservice.data.dao

import androidx.room.*
import project.productsandservice.data.models.Session

@Dao
interface SessionDAO {
    @Query("SELECT * FROM session")
    fun getSessionAll(): List<Session>

    @Query("SELECT * FROM session WHERE user_id")
    fun getSessionUser(): Session

    @Query("SELECT * FROM session WHERE user_id=:user_id")
    fun setSessionUser(user_id: Int): Session

    @Query("SELECT * FROM session WHERE isStatus=:status")
    fun setStatusSession(status: String): Session

    @Insert
    fun createSession(session: Session)

    @Delete
    fun deleteSession(session: Session)
}