package project.productsandservice.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Advert(
    val title: String,
    val description: String,
    val price: String,
    val media_file: List<String>,
    val date_added: String,
    val author_advert: User,
    val isStatus: Status
): Serializable, Parcelable
