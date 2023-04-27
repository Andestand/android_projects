package ru.project.examtest.data.models;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(
        tableName = "tables"
)
public class RoomTables implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "link")
    public String link;

    public RoomTables(
            String title,
            String link
    ) {
        this.title = title;
        this.link = link;
    }
}
