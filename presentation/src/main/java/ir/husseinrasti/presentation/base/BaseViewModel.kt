package ir.husseinrasti.presentation.base

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import ir.husseinrasti.domain.base.*
import ir.husseinrasti.domain.base.ResultState.Status.*
import ir.husseinrasti.presentation.R
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var resources: Resources

    protected val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    @Suppress("UNCHECKED_CAST")
    protected fun <RESULT, BODY, DomainObject : ResultState<*>> ResultMutableLiveData<RESULT>.convertRxToLiveData(
        body: BODY,
        useCase: BaseUseCase<BODY, DomainObject>
    ) {
        useCase.invoke(body)
            .doOnSubscribe { loading() }
            .subscribe { result ->
                when (result.status) {
                    SUCCESS -> {
                        success(result.data as RESULT)
                    }
                    ERROR -> {
                        error(createError(result.exp))
                    }
                }
            }.addTo(compositeDisposable)
    }

    private fun createError(ext: Failure?): ResultError {
        return when (ext) {
            is Failure.HttpException -> ResultError(
                code = ResultError.HTTP_EXCEPTION,
                message = ext.message,
                show = true
            )
            is Failure.UnknownHostException -> ResultError(
                code = ResultError.UNKNOWN_HOST_EXCEPTION,
                message = ext.message,
                show = true
            )
            is Failure.ApiValidationException -> ResultError(
                code = ResultError.API_VALIDATION_EXCEPTION,
                message = ext.message,
                show = true
            )
            is Failure.FailureWithMessage -> ResultError(
                code = ResultError.FAILURE,
                message = ext.message,
                show = true
            )
            else -> ResultError(
                code = ResultError.OTHER,
                message = resources.getString(R.string.error_an_error_occur_try_again),
                show = true
            )
        }
    }

}