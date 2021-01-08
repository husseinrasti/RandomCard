package ir.husseinrasti.presentation.base

data class ResultWrapper<T>(
    val status: Status,
    val data: T? = null,
    val error: ResultError? = null
) {
    companion object {

        fun <T> loading(): ResultWrapper<T> = ResultWrapper(Status.LOADING)

        fun <T> success(data: T): ResultWrapper<T> = ResultWrapper(Status.SUCCESS, data)

        fun <T> error(error: ResultError): ResultWrapper<T> = ResultWrapper(Status.ERROR, error = error)

    }

    enum class Status {
        LOADING, SUCCESS, ERROR
    }

}

class ResultError(val code: Int?, val message: String? = null, var show: Boolean = true) {
    companion object {
        const val HTTP_EXCEPTION = 100
        const val UNKNOWN_HOST_EXCEPTION = 101
        const val API_VALIDATION_EXCEPTION = 102
        const val FAILURE = 103
        const val OTHER = 104
    }
}