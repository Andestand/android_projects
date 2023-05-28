package project.productsandservice.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chat(
    var id: Int,
    val users: String,
    val messages: List<Message>
): Parcelable
