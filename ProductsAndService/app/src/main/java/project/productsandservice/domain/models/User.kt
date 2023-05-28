package project.productsandservice.domain.models

import android.os.Parcelable
import androidx.room.*
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = "users"
)
@Parcelize
data class User(
    @PrimaryKey(
        autoGenerate = true
    ) var id: Int? = null,

    @ColumnInfo(
        name = "avatar"
    ) val avatar: String,

    @ColumnInfo(
        name = "username"
    ) val username: String,

    @ColumnInfo(
        name = "first_name"
    ) val first_name: String,

    @ColumnInfo(
        name = "last_name"
    ) val last_name: String,

    @ColumnInfo(
        name = "surname"
    ) val surname: String,

    @ColumnInfo(
        name = "email"
    ) val email: String,

    @ColumnInfo(
        name = "password"
    ) val password: String,

    @ColumnInfo(
        name = "city"
    ) val city: String,

    @ColumnInfo(
        name = "date_registration"
    ) val date_registration: String
): Parcelable
