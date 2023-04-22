package ru.project.examtest.data.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "terms"
)
public class RoomTerms {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "description")
    public String description;

    public RoomTerms(
            String title,
            String description
    ) {
        this.title = title;
        this.description = description;
    }
}
