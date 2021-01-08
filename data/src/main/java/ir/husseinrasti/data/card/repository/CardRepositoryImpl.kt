package ir.husseinrasti.data.card.repository

import android.util.Log
import io.reactivex.rxjava3.core.Observable
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

    override fun getRandomCard(): Single<ResultState<Card>> = cardDataSource.getCards()

//    override fun getRandomCard(): Observable<ResultState<Card>> {
//        Log.i("card", "Get random card")
//        return cardDataSource.getCards().map {
//            Log.i("card", "Cards: ${it.data}")
//            val card = it.data?.random()
//            Log.i("card", "Random Card: $card")
//            ResultState(it.status, card, it.exp)
//        }
//    }

}