package ir.husseinrasti.presentation.base

import androidx.lifecycle.LiveData

open class ResultLiveData<T> : LiveData<ResultWrapper<T>>()

open class ResultMutableLiveData<T> : ResultLiveData<T>() {

    fun success(t: T) {
        postValue(ResultWrapper.success(t))
    }

    fun error(error: ResultError) {
        postValue(ResultWrapper.error(error))
    }

    fun loading() {
        postValue(ResultWrapper.loading())
    }

}