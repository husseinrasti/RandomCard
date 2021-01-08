package ir.husseinrasti.data.card.entity

import com.google.gson.annotations.SerializedName
import ir.husseinrasti.data.base.ResponseObject
import ir.husseinrasti.domain.card.entity.Card

data class CardEntity(
    @SerializedName("code")
    val code: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("sound")
    val sound: String,
    @SerializedName("tag")
    val tag: String,
    @SerializedName("title")
    val title: String
) : ResponseObject<Card> {
    override fun toDomain(): Card = Card(code, description, image, sound, tag, title)
}

data class CardWrapper(
    @SerializedName("cards")
    val list: List<CardEntity>
)