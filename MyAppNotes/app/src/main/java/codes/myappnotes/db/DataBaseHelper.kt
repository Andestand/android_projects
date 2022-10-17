package codes.myappnotes.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context): SQLiteOpenHelper(context, DataBaseNames.DATABASE_NAME, null, DataBaseNames.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        /** Создаёт таблицу в базе данных **/
        db?.execSQL(DataBaseNames.SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        /** Удаляет а затем создаёт заново базу данных **/
        db?.execSQL(DataBaseNames.SQL_DELETE_TABLE)
        onCreate(db)
    }
}
