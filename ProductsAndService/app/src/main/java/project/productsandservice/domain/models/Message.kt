package project.productsandservice.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Message(
    val message: String,
    val datetime: String,
    var type: Int
): Parcelable
