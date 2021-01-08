package ir.husseinrasti.presentation.base.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import ir.husseinrasti.presentation.base.BaseFragment
import ir.husseinrasti.presentation.base.ResultError
import ir.husseinrasti.presentation.base.ResultWrapper
import ir.husseinrasti.presentation.base.ResultWrapper.Status.*

fun <T> LiveData<ResultWrapper<T>>.observeResult(
    owner: BaseFragment,
    onSuccess: (result: T?) -> Unit,
    onError: (ResultError?) -> Unit
) {
    observe(owner.viewLifecycleOwner, Observer {
        when (it.status) {
            LOADING -> {
                owner.loading(true)
            }
            SUCCESS -> {
                owner.loading(false)
                onSuccess(it.data)
            }
            ERROR -> {
                owner.loading(false)
                onError(it.error)
                owner.showError(it.error)
            }
        }
    })
}