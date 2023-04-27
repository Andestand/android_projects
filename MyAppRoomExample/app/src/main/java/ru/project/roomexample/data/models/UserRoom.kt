package ru.project.roomexample.data.models

import androidx.room.*

@Entity(
    tableName = "users"
)
data class UserRoom(
    @PrimaryKey var id: Int? = null,

    @ColumnInfo(
        name = "username"
    ) val username: String,

    @ColumnInfo(
        name = "password"
    ) val password: String
)
