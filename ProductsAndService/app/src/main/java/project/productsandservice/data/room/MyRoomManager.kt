package project.productsandservice.data.room

import androidx.room.*
import project.productsandservice.data.dao.*
import project.productsandservice.data.models.Session
import project.productsandservice.domain.models.User

@Database(
    entities = [
        Session::class,
        User::class
    ],
    version = 1
)
abstract class MyRoomManager: RoomDatabase() {
    abstract fun sessionDAO(): SessionDAO
    abstract fun userDAO(): UserDAO
}