package ir.husseinrasti.domain.base

/**
 * A generic class that holds a value with its loading status.
 *
 * Result is usually created by the Repository classes where they return
 * `Result<T>` to pass back the latest data to the UI with its fetch status.
 */

data class ResultState<out T>(
    val status: Status,
    val data: T?,
    val exp: Failure?
) {

    enum class Status {
        SUCCESS,
        ERROR
    }

    companion object {
        fun <T> success(data: T, exp: Failure? = null): ResultState<T> = ResultState(Status.SUCCESS, data, exp)

        fun <T> error(exp: Failure, data: T? = null): ResultState<T> = ResultState(Status.ERROR, data, exp)
    }

}