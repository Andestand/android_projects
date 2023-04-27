package ru.project.examtest.data.models;

import androidx.room.*;

import java.io.Serializable;

@Entity(
        tableName = "tasks"
)
public class RoomTasks implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "link")
    public String link;

    public RoomTasks(
            String title,
            String link
    ) {
        this.title = title;
        this.link = link;
    }
}
