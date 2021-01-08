package ir.husseinrasti.domain.card.repository

import io.reactivex.rxjava3.core.Single
import ir.husseinrasti.domain.base.ResultState
import ir.husseinrasti.domain.card.entity.Card

interface CardRepository {

    fun getRandomCard(): Single<ResultState<Card>>

}