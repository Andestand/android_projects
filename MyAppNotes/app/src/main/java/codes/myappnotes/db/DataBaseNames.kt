package codes.myappnotes.db

import android.provider.BaseColumns

object DataBaseNames: BaseColumns {
    const val DATABASE_NAME = "database_notes.db"
    const val TABLE_NAME = "notes"
    const val TABLE_HEADER = "header"
    const val TABLE_TEXT = "text"
    const val DATABASE_VERSION = 1

    const val SQL_CREATE_TABLE = "CREATE TABLE $TABLE_NAME(" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "$TABLE_HEADER TEXT NOT NULL," +
            "$TABLE_TEXT TEXT NOT NULL)"

    const val SQL_DELETE_TABLE = "DROP TABLE $TABLE_NAME"

}
