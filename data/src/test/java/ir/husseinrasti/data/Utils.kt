package ir.husseinrasti.data

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.observers.TestObserver
import java.io.File

class Utils {

    companion object {

        fun getJson(path: String): String {
            val uri = this.javaClass.classLoader.getResource(path)
            val file = File(uri.path)
            return String(file.readBytes())
        }
    }
}

inline fun <reified T : Any> TestObserver<T>.assertGeneralsSuccess(noinline asserts: (T) -> Boolean = { true }) {
    assertComplete()
    assertValueCount(1)
    assertNoErrors()
    assertValue {
        asserts(it)
    }
}

inline fun <reified T : Any> TestObserver<T>.assertGeneralsError(noinline asserts: (Throwable) -> Boolean = { true }) {
    assertValueCount(0)
    assertError {
        asserts(it)
    }
}

inline fun <reified T> getSingleResultSuccess(value: T): Single<T> =
    Single.just(value)

inline fun <reified T : List<Any>> getSingleListResultSuccess(value: T): Single<T> =
    Single.just(value)

inline fun <reified T> getSingleError(value: Throwable): Single<T> = Single.error(value)

inline fun <reified T : Any> Single<T>.testAwait(): TestObserver<T> = this.test().apply {
    this.await()
}
