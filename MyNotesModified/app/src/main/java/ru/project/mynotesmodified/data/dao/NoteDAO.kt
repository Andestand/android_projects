package ru.project.mynotesmodified.data.dao

import androidx.room.*
import ru.project.mynotesmodified.domain.models.Note

@Dao
interface NoteDAO {

    @Query("SELECT * FROM notes")
    fun getNotes(): List<Note>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addNote(note: Note): Long

    @Delete
    fun deleteNote(vararg note: Note)
}