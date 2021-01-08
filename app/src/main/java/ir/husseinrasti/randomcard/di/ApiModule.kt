package ir.husseinrasti.randomcard.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.husseinrasti.data.card.remote.CardApi
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {

    @Provides
    fun products(retrofit: Retrofit): CardApi = retrofit.create(CardApi::class.java)

}