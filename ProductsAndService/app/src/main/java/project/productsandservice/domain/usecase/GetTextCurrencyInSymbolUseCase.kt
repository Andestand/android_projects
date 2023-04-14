package project.productsandservice.domain.usecase

class GetTextCurrencyInSymbolUseCase {

    fun execute(currency: String): String? {
        when(currency) {
            "Рубль" -> {
                return "₽"
            }
            "Доллар" -> {
                return "$"
            }
            "Евро" -> {
                return "€"
            }
            "Тенге" -> {
                return "₸"
            }
            else -> {
                return null
            }
        }
    }
}