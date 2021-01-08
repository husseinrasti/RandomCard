package ir.husseinrasti.data.card.remote

import io.reactivex.rxjava3.core.Single
import ir.husseinrasti.data.card.entity.CardEntity
import ir.husseinrasti.data.card.entity.CardWrapper
import retrofit2.Response
import retrofit2.http.GET

interface CardApi {

    @GET("tempelate.json")
    fun getCards(): Single<Response<CardWrapper>>

}