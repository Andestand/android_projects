package ru.project.examtest.data.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "teachers"
)
public class RoomTeacher {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "username")
    public String username;

    @ColumnInfo(name = "password")
    public String password;

    public RoomTeacher(
            String username,
            String password
    ) {
        this.username = username;
        this.password = password;
    }
}
