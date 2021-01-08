package ir.husseinrasti.data.card.repository

import io.reactivex.rxjava3.core.Single
import ir.husseinrasti.data.card.datasource.CardDataSource
import ir.husseinrasti.domain.base.ResultState
import ir.husseinrasti.domain.card.entity.Card
import ir.husseinrasti.domain.card.repository.CardRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CardRepositoryImpl @Inject constructor(
    private val cardDataSource: CardDataSource
) : CardRepository {

    override fun getRandomCard(): Single<ResultState<Card>> = cardDataSource.getRandomCard()

}