package ru.project.mynotesmvp.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "notes"
)
data class Note(
    @PrimaryKey(
        autoGenerate = true
    ) val id: Int? = null,

    @ColumnInfo(
        name = "title"
    ) val title: String,

    @ColumnInfo(
        name = "description"
    ) val description: String,

    @ColumnInfo(
        name = "image_link"
    ) val image_link: String,

    @ColumnInfo(
        name = "date_publication"
    ) val date_publication: String
): java.io.Serializable
