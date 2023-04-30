package ru.project.examtest.data.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(
        tableName = "tests_oge_p"
)
public class RoomTestOgeP {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "text")
    public String text;

    @ColumnInfo(name = "correct_answer")
    public String correct_answer;

    public RoomTestOgeP(String text, String correct_answer) {
        this.text = text;
        this.correct_answer = correct_answer;
    }
}
