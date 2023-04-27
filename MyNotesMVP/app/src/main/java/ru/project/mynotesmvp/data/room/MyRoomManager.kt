package ru.project.mynotesmvp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.project.mynotesmvp.data.dao.NotesDAO
import ru.project.mynotesmvp.data.models.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class MyRoomManager: RoomDatabase() {
    abstract fun notesDAO(): NotesDAO
}