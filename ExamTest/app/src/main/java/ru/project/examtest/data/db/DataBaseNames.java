package ru.project.examtest.data.db;

import android.provider.BaseColumns;

public class DataBaseNames {
    public static final String database_name = "database.db";
    public static final int database_version = 1;
    public static final String table_name_teachers = "teachers";
    public static final String table_username_teachers = "username";
    public static final String table_password_teachers = "password";

    public static final String SQL_CREATE_TABLE_TEACHERS = "CREATE TABLE "+ table_name_teachers +
            "(" +
            BaseColumns._ID + " INTEGER PRIMARY KEY," +
            table_username_teachers + " TEXT," +
            table_password_teachers + " TEXT" +
            ")";

    public static final String SQL_DELETE_TABLE_TEACHERS = "DROP TABLE IF EXISTS "
            + table_name_teachers;
}
