package ir.husseinrasti.data.base


import android.content.res.Resources
import androidx.annotation.MainThread
import androidx.annotation.StringRes
import androidx.annotation.WorkerThread
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.PublishSubject
import ir.husseinrasti.data.R
import ir.husseinrasti.domain.base.*
import ir.husseinrasti.domain.base.ResultState.Status.*
import retrofit2.Response

/**
 * A generic class that can provide a resource backed by both the sqlite database and the network.
 *
 *
 * You can read more about it in the [Architecture
 * Guide](https://developer.android.com/arch).
 * @param <ResultType>
 * @param <RequestType>
</RequestType></ResultType> */
abstract class NetworkBoundResource<DomainObject, ApiObject> @MainThread constructor(
    private val resources: Resources,
    @StringRes
    private val validationErrorMessage: Int = R.string.msgFailedApiValidation,
    @StringRes
    private val errorMessage: Int = R.string.msgFailedConnection
) {

    private val publishSubject = PublishSubject.create<ResultState<DomainObject>>()

    init {
        @Suppress("LeakingThis")
        fetchFromNetwork()
    }

    @MainThread
    private fun setValue(newValue: ResultState<DomainObject>?) {
        publishSubject.onNext(newValue)
        publishSubject.onComplete()
    }

    private fun fetchFromNetwork() {
        createCall().getResponse(resources) { saveCallResult(it) }
            .subscribe { result, exp ->
                when (result.status) {
                    SUCCESS -> {
                        loadFromDb().subscribe {
                            setValue(ResultState.success(it))
                        }
                    }
                    ERROR -> {
                        setValue(ResultState.error(Failure.FailureWithMessage(exp.message, FAILED_CODE)))
                    }
                }
            }
    }

    fun asResult(): Observable<ResultState<DomainObject>> = publishSubject

    @WorkerThread
    protected abstract fun saveCallResult(data: ApiObject?)

    @MainThread
    protected abstract fun shouldFetch(data: DomainObject?): Boolean

    @MainThread
    protected abstract fun loadFromDb(): Observable<DomainObject>

    @MainThread
    protected abstract fun createCall(): Single<Response<ApiObject>>

}