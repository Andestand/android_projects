package ru.project.roomexample.data.models

import androidx.room.*
import java.io.Serializable

@Entity(
    tableName = "users",
    indices = [
        Index(
            value = ["username", "password"],
            unique = true
        )
    ]
)
data class UserRoom(
    @PrimaryKey(
        autoGenerate = true
    ) var id: Int? = null,

    @ColumnInfo(
        name = "username"
    ) var username: String,

    @ColumnInfo(
        name = "password"
    ) var password: String
): Serializable
