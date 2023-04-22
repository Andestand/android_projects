package ru.project.roomexample.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.project.roomexample.data.interfaces.UserDAO
import ru.project.roomexample.data.models.UserRoom

@Database(
    entities = [UserRoom::class],
    version = 1
)
abstract class MyRoomManager: RoomDatabase() {
    abstract fun userDAO(): UserDAO
}