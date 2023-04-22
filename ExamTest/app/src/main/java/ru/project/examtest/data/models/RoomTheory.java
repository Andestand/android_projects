package ru.project.examtest.data.models;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "theorys"
)
public class RoomTheory {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "text")
    public String text;


    public RoomTheory(
            String text
    ) {
        this.text = text;
    }
}
