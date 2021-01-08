package ir.husseinrasti.randomcard.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.husseinrasti.data.card.datasource.CardDataSource
import ir.husseinrasti.data.card.repository.CardRepositoryImpl
import ir.husseinrasti.domain.card.repository.CardRepository

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    fun provideCardRepository(
        cardDataSource: CardDataSource
    ): CardRepository = CardRepositoryImpl(cardDataSource)

}