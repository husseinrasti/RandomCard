package ir.husseinrasti.presentation.base.extensions

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import ir.husseinrasti.presentation.base.BaseFragment
import ir.husseinrasti.presentation.base.ResultWrapper
import ir.husseinrasti.presentation.base.ResultWrapper.Status.*

fun <T> LiveData<ResultWrapper<T>>.observeResult(
    owner: BaseFragment,
    onSuccess: (result: T) -> Unit
) {
    observe(owner.viewLifecycleOwner, Observer {
        when (it.status) {
            LOADING -> {
                owner.loading(true)
            }
            SUCCESS -> {
                it.getResponseIfNotHandled()?.let { response ->
                    owner.loading(false)
                    onSuccess(response)
                }
            }
            ERROR -> {
                it.getErrorIfNotHandled()?.let { error ->
                    owner.loading(false)
                    owner.showError(error)
                }
            }
        }
    })
}