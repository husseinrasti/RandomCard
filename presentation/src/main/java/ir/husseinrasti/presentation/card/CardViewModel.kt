package ir.husseinrasti.presentation.card

import androidx.hilt.lifecycle.ViewModelInject
import ir.husseinrasti.domain.card.entity.Card
import ir.husseinrasti.domain.card.usecase.GetRandomCardUseCase
import ir.husseinrasti.domain.card.usecase.GetRandomCardUseCaseParams
import ir.husseinrasti.presentation.base.*

class CardViewModel @ViewModelInject constructor(
    private val getRandomCardUseCase: GetRandomCardUseCase
) : BaseViewModel() {

    private val _randomCard = ResultMutableLiveData<Card>()
    val randomCard: ResultLiveData<Card> = _randomCard

    fun getCard() {
        _randomCard.convertRxToLiveData(
            body = GetRandomCardUseCaseParams(""),
            useCase = getRandomCardUseCase
        )
    }

}