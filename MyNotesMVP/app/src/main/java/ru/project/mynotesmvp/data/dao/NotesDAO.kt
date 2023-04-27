package ru.project.mynotesmvp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ru.project.mynotesmvp.data.models.Note

@Dao
interface NotesDAO {
    @Query("SELECT * FROM notes")
    fun notesAll(): List<Note>

    @Insert
    fun addNote(note: Note)

    @Delete
    fun deleteNote(note: Note)
}
