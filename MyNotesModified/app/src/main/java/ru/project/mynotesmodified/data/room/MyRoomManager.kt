package ru.project.mynotesmodified.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.project.mynotesmodified.data.dao.NoteDAO
import ru.project.mynotesmodified.domain.models.Note

@Database(
    entities = [
        Note::class
    ],
    version = 1
)
abstract class MyRoomManager: RoomDatabase() {
    abstract fun noteDAO(): NoteDAO
}