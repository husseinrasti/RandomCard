package ir.husseinrasti.data.base

import android.content.res.Resources
import androidx.annotation.StringRes
import io.reactivex.rxjava3.core.*
import ir.husseinrasti.data.R
import ir.husseinrasti.domain.base.*
import retrofit2.HttpException
import retrofit2.Response
import java.net.UnknownHostException

fun <T> Single<T>.validate(message: String): Single<T> = map {
    if (it is Response<*>) {
        if (!it.isSuccessful) {
            throw Failure.ApiValidationException(message, it.code())
        }
    }
    it
}

fun <T> Single<T>.errorResult(message: String): Single<T> = onErrorReturn {
    it.printStackTrace()
    when (it) {
        is Failure.ApiValidationException -> {
            ResultState.error(it, data = null) as T
        }
        is HttpException -> {
            ResultState.error(Failure.HttpException(it.message, it.code()), data = null) as T
        }
        is UnknownHostException -> {
            ResultState.error(Failure.UnknownHostException(it.message, FAILED_UNKNOWN_HOST_CODE), data = null) as T
        }
        else -> {
            ResultState.error(Failure.FailureWithMessage(it.message, FAILED_CODE), data = null) as T
        }
    }
}

@Suppress("UNCHECKED_CAST")
fun <ApiObject> Single<Response<ApiObject>>.getResponse(
    resources: Resources,
    @StringRes validationErrorMessage: Int = R.string.msgFailedApiValidation,
    @StringRes errorMessage: Int = R.string.msgFailedApiValidation,
    actionSuccess: (ApiObject) -> Unit
): Single<ResultState<ApiObject>> = validate(resources.getString(validationErrorMessage))
    .map { result ->
        if (result?.body() == null) {
            ResultState.error(Failure.FailureWithMessage(resources.getString(R.string.msgEmpty), EMPTY_LIST_CODE))
        } else {
            actionSuccess(result.body() as ApiObject)
            ResultState.success(result.body() as ApiObject)
        }
    }
    .errorResult(resources.getString(errorMessage))