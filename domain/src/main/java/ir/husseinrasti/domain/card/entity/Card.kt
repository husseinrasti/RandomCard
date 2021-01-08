package ir.husseinrasti.domain.card.entity

data class Card(
    val code: Int = 0,
    val description: String = "",
    val image: String? = "",
    val sound: String? = "",
    val tag: String = "",
    val title: String = ""
)