package ir.husseinrasti.data.card.entity

import ir.husseinrasti.domain.base.Failure
import ir.husseinrasti.domain.base.ResultState
import ir.husseinrasti.domain.card.entity.Card

fun provideCardWrapper() = CardWrapper(
    list = provideListCard()
)

fun provideListCard() = listOf(
    CardEntity(0, "desc", "image", "sound", "tag", "title"),
    CardEntity(1, "desc", "image", "sound", "tag", "title"),
    CardEntity(2, "desc", "image", "sound", "tag", "title")
)

fun provideCard() = Card(0, "desc", "image", "sound", "tag", "title")

fun provideResultStateCardSuccess() = ResultState(
    status = ResultState.Status.SUCCESS,
    data = Card(0, "desc", "image", "sound", "tag", "title"),
    exp = null
)

fun provideResultStateCardError(): Throwable = Failure.FailureWithMessage("Failure", -1)