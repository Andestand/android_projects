package ru.project.workaccounting.domain.models

import androidx.room.*


@Entity(
    tableName = "works"
)
data class Work(
    @PrimaryKey(
        autoGenerate = true
    ) val id: Long? = null,

    @ColumnInfo val workName: String,

    @ColumnInfo val sizeWork: Int
)
