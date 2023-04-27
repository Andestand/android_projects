package ru.project.examtest.data.models;

import androidx.room.*;
import java.io.Serializable;


@Entity(
        tableName = "basic_formulas"
)
public class RoomBasicFormula implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "formula")
    public String formula;

    @ColumnInfo(name = "description")
    public String description;

    public RoomBasicFormula(
            String formula,
            String description
    ) {
        this.formula = formula;
        this.description = description;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}