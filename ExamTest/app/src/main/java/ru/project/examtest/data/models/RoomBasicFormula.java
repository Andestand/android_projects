package ru.project.examtest.data.models;

import androidx.room.*;
import java.io.Serializable;

@Entity(
        tableName = "basic_formulas"
)
public class RoomBasicFormula implements Serializable {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "text")
    public String text;

    public RoomBasicFormula(
            String text
    ) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
