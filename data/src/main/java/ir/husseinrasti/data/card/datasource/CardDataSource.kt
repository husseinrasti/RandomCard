package ir.husseinrasti.data.card.datasource

import android.content.res.Resources
import android.util.Log
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import ir.husseinrasti.data.base.NetworkBoundResource
import ir.husseinrasti.data.base.getResponse
import ir.husseinrasti.data.card.entity.CardWrapper
import ir.husseinrasti.data.card.remote.CardApi
import ir.husseinrasti.domain.base.ResultState
import ir.husseinrasti.domain.card.entity.Card
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class CardDataSource @Inject constructor(
    private val resources: Resources,
    private val cardApi: CardApi
) {

    var listCard = listOf<Card>() //it can be DAO of room

//    fun getCards(): Observable<ResultState<List<Card>>> = object : NetworkBoundResource<List<Card>, CardWrapper>(resources) {
//        override fun saveCallResult(data: CardWrapper) {
//            listCard = data.list.map { it.toDomain() }
//            Log.i("card", "saved list: $listCard")
//        }
//
//        override fun shouldFetch(): Boolean = listCard.isNullOrEmpty()
//
//        override fun loadFromDb(): List<Card> {
//            Log.i("card", "load from db: $listCard")
//            return listCard
//        }
//
//        override fun createCall(): Single<Response<CardWrapper>> = cardApi.getCards()
//    }.asResult()

    fun getCards(): Single<ResultState<Card>> = if (listCard.isNullOrEmpty()) {
        cardApi.getCards().getResponse(resources) {
            listCard = it.list.map { item -> item.toDomain() }
        }.map {
            ResultState(it.status, listCard.random(), it.exp)
        }
    } else {
        Single.just(ResultState.success(listCard.random()))
    }


}