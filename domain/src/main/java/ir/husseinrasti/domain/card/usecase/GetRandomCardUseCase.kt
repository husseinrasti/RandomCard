package ir.husseinrasti.domain.card.usecase

import io.reactivex.rxjava3.core.Single
import ir.husseinrasti.domain.base.BaseUseCase
import ir.husseinrasti.domain.base.ResultState
import ir.husseinrasti.domain.card.entity.Card
import ir.husseinrasti.domain.card.repository.CardRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetRandomCardUseCase @Inject constructor(
    private val repository: CardRepository
) : BaseUseCase<GetRandomCardUseCaseParams, ResultState<Card>> {

    override fun invoke(params: GetRandomCardUseCaseParams): Single<ResultState<Card>> = repository.getRandomCard()

}


inline class GetRandomCardUseCaseParams(val value: String)