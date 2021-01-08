package ir.husseinrasti.domain.base

sealed class Failure(open val msg: String?, open val code: Int?) : Throwable() {

    class HttpException(override val msg: String?, override val code: Int?) : Failure(msg, code)

    class UnknownHostException(override val msg: String?, override val code: Int?) : Failure(msg, code)

    class ApiValidationException(override val msg: String?, override val code: Int?) : Failure(msg, code)

    class FailureWithMessage(override val msg: String?, override val code: Int?) : Failure(msg, code)

}