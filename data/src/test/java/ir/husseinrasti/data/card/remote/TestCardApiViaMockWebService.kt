package ir.husseinrasti.data.card.remote

import io.reactivex.rxjava3.observers.TestObserver
import ir.husseinrasti.data.BuildConfig
import ir.husseinrasti.data.Utils
import ir.husseinrasti.data.card.entity.CardEntity
import ir.husseinrasti.data.card.entity.CardWrapper
import ir.husseinrasti.data.card.entity.provideCardWrapper
import ir.husseinrasti.data.card.entity.provideListCard
import ir.husseinrasti.domain.base.Failure
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@RunWith(JUnit4::class)
class TestCardApiViaMockWebService {

    lateinit var cardApi: CardApi
    lateinit var mockWebServer: MockWebServer

    @Before
    @Throws
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start()

        val okHttpClient = OkHttpClient.Builder().build()
        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .baseUrl(mockWebServer.url("/").toString())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        cardApi = retrofit.create(CardApi::class.java)

        println("Setup mock web server")
    }

    @Test
    fun `get list of cards from mocked server`() {
        println("Run test get list of cards")
        val testObserver = TestObserver<List<CardEntity>>()
        val path = "/db"
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody(Utils.getJson("json/db"))

        mockWebServer.enqueue(mockResponse)
        cardApi.getCards().map { it.body()?.list }.subscribe(testObserver)
        testObserver.await(2, TimeUnit.SECONDS)

        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
//        testObserver.assertResult(provideListCard()) //it must be the same JSON

        val request = mockWebServer.takeRequest()

        assertEquals(path, request.path)
        println("Finish test get list of cards")
    }

    @After
    @Throws
    fun tearDown() {
        println("Shutdown mock web server")
        mockWebServer.shutdown()
    }

}