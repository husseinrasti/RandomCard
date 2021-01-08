package ir.husseinrasti.data.card.datasource

import android.content.res.Resources
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import ir.husseinrasti.data.base.NetworkBoundResource
import ir.husseinrasti.data.card.entity.CardWrapper
import ir.husseinrasti.data.card.remote.CardApi
import ir.husseinrasti.domain.base.ResultState
import ir.husseinrasti.domain.card.entity.Card
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CardDataSource @Inject constructor(
    private val resources: Resources,
    private val cardApi: CardApi
) {

    var listCard = listOf<Card>() //it can be DAO of room

    fun getRandomCard(): Single<ResultState<Card>> = object : NetworkBoundResource<Card, CardWrapper>(resources) {
        override fun saveCallResult(data: CardWrapper?) {
            listCard = data?.list?.map { it.toDomain() }!!
        }

        override fun shouldFetch(data: Card?): Boolean = listCard.isNullOrEmpty()

        override fun loadFromDb(): Observable<Card> = Observable.just(listCard.random())

        override fun createCall(): Single<Response<CardWrapper>> = cardApi.getCards()

    }.asResult().firstOrError()

}