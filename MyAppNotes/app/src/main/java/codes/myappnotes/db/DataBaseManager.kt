package codes.myappnotes.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import codes.myappnotes.Note

class DataBaseManager(context: Context?) {
    private val dataBaseHelper = context?.let { DataBaseHelper(it) }
    private var db: SQLiteDatabase? = null

    fun openDB() {
        db = dataBaseHelper?.writableDatabase
    }

    fun addDataDB(note: Note) {
        val values = ContentValues().apply {
            put(DataBaseNames.TABLE_HEADER, note.header)
            put(DataBaseNames.TABLE_TEXT, note.text)
        }

        db?.insert(DataBaseNames.TABLE_NAME, null, values)
    }

    @SuppressLint("Recycle", "Range")
    fun readDataDB(): ArrayList<Note> {
        val dataListNote = ArrayList<Note>()

        val cursor = db?.query(
            DataBaseNames.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null
        )

        with(cursor) {
            while (this?.moveToNext()!!) {
                val header = getString(getColumnIndexOrThrow(DataBaseNames.TABLE_HEADER))
                val text = getString(getColumnIndexOrThrow(DataBaseNames.TABLE_TEXT))
                dataListNote.add(Note(header, text))
            }
        }

        cursor?.close()
        return dataListNote
    }

    fun changeDataDB(note: Note, initial_note: Note) {
        val values = ContentValues().apply {
            put(DataBaseNames.TABLE_HEADER, note.header)
            put(DataBaseNames.TABLE_TEXT, note.text)
        }

        db?.update(DataBaseNames.TABLE_NAME,
            values,
            "${DataBaseNames.TABLE_HEADER}='${initial_note.header}' OR" +
                    " ${DataBaseNames.TABLE_TEXT}='${initial_note.text}'",
            null
        )
    }

    fun deleteNote(note: Note) {
        val deleteNoteData = "${DataBaseNames.TABLE_HEADER} = '${note.header}' " +
                "OR ${DataBaseNames.TABLE_TEXT} = '${note.text}'"

        db?.delete(DataBaseNames.TABLE_NAME, deleteNoteData, null)
    }
}
