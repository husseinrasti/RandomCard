package ir.husseinrasti.data.card.repository

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.whenever
import ir.husseinrasti.data.*
import ir.husseinrasti.data.card.datasource.CardDataSource
import ir.husseinrasti.data.card.entity.*
import ir.husseinrasti.domain.base.Failure
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TestCardRepositoryImpl {

    private lateinit var cardRepositoryImpl: CardRepositoryImpl

    @Mock
    private lateinit var cardDataSource: CardDataSource

    @Before
    fun setup() {
        cardRepositoryImpl = CardRepositoryImpl(cardDataSource)
    }

    @Test
    fun `get random card with result success`() {
        whenever(cardDataSource.getCards())
            .doReturn(getSingleResultSuccess(provideResultStateCardSuccess()))

        val testObserver = cardDataSource.getCards().test()

        testObserver.assertGeneralsSuccess() { it != null }
    }

    @Test
    fun `get random card with result error`() {
        whenever(cardDataSource.getCards())
            .doReturn(getSingleError(provideResultStateCardError()))

        val testObserver = cardDataSource.getCards().test()

        testObserver.assertGeneralsError { it is Failure }
    }

    @Test
    fun `get random card in case of an error`() {
        whenever(cardDataSource.getCards())
            .doReturn(getSingleError(Failure.FailureWithMessage("Failure", -1)))

        val testObserver = cardDataSource.getCards().test()

        testObserver.assertGeneralsError { it is Failure }
    }

}