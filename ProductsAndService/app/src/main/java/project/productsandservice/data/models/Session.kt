package project.productsandservice.data.models

import androidx.room.*

@Entity(
    tableName = "session"
)
data class Session(
    @PrimaryKey(
        autoGenerate = true
    ) var id: Int? = null,

    @ColumnInfo(
        name = "device_name"
    ) var device_name: String,

    @ColumnInfo(
        name = "user_id"
    ) var user_id: Int,

    @ColumnInfo(
        name = "isStatus"
    ) var isStatus: String
)
