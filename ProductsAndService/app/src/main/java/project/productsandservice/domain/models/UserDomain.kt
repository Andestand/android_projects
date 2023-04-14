package project.productsandservice.domain.models

data class UserDomain(
    val avatar: Int?,
    val username: String,
    val first_name: String,
    val last_name: String,
    val surname: String,
    val password: String,
    val city: String,
    val date_registration: String
)
