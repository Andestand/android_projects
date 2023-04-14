package project.productsandservice.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import project.productsandservice.data.models.User

@Parcelize
data class Chat(
    var id: Int,
    val users: String,
    val messages: List<Message>
): Parcelable
