package ir.husseinrasti.presentation.base

import android.content.res.Resources
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import ir.husseinrasti.domain.base.BaseUseCase
import ir.husseinrasti.domain.base.FAILED_CODE
import ir.husseinrasti.domain.base.Failure
import ir.husseinrasti.domain.base.ResultState
import ir.husseinrasti.domain.base.ResultState.Status.*
import ir.husseinrasti.presentation.R
import javax.inject.Inject

open class BaseViewModel @ViewModelInject constructor() : ViewModel() {

    @Inject
    lateinit var resources: Resources

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    @Suppress("UNCHECKED_CAST")
    protected fun <RESULT, BODY, DomainObject : ResultState<*>> ResultMutableLiveData<RESULT>.convertRxToLiveData(
        body: BODY,
        useCase: BaseUseCase<BODY, DomainObject>,
        doOnSuccess: (() -> Unit)? = null
    ) {
        useCase.invoke(body)
            .doOnSubscribe { loading() }
            .subscribe { result ->
                when (result.status) {
                    SUCCESS -> {
                        doOnSuccess?.invoke()
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
                message = ext.message
            )
            is Failure.UnknownHostException -> ResultError(
                code = ResultError.UNKNOWN_HOST_EXCEPTION,
                message = ext.message
            )
            is Failure.ApiValidationException -> ResultError(
                code = ResultError.API_VALIDATION_EXCEPTION,
                message = ext.message
            )
            is Failure.FailureWithMessage -> ResultError(
                code = ResultError.FAILURE,
                message = ext.message
            )
            else -> ResultError(
                code = ResultError.OTHER,
                message = resources.getString(R.string.error_an_error_occur_try_again)
            )
        }
    }

}