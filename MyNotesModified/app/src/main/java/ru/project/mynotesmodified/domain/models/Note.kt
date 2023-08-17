package ru.project.mynotesmodified.domain.models

import androidx.room.*

@Entity(
    tableName = "notes"
)
data class Note(
    @PrimaryKey(
        autoGenerate = true
    ) var id: Int? = null,

    @ColumnInfo(
        name = "title"
    ) val title: String,

    @ColumnInfo(
        name = "description"
    ) val description: String,

    @ColumnInfo(
        name = "datetime"
    ) val datetime: String
)