package project.productsandservice.data.arrays

import project.productsandservice.domain.models.MessageUser

object MessageUsersArray {
    val array = listOf(
        MessageUser(
            username = "София Фильвенова",
            avatar = "https://sun9-54.userapi.com/impg/VcaLLa-2KcFuZa8TBkMYH3d3RNhW5kpZ7axD-w/0Q" +
                    "z4QLmWabs.jpg?size=855x956&quality=96&sign=5fcffeac556a0830d3f9326ca7ee9936&type=album",
            message = "приветик!!!",
            datetime = "13.08.2022"
        ),
        MessageUser(
            username = "Марина Ульянова",
            avatar = "https://sun9-41.userapi.com/impg/CCamIdHuVtA0i0bSf7q8OHmukdflCds6c1oEpQ/Pz" +
                    "G-udHdKJg.jpg?size=1280x1280&quality=96&sign=83b80d4d9c92c2d4c70a113b2ca54ff4&type=album",
            message = "приветик!!!",
            datetime = "9.05.2009"
        )
    )
}