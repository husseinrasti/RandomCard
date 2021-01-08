package ir.husseinrasti.presentation.base

import android.app.ProgressDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import ir.husseinrasti.presentation.R

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    private var mProgressDialog: ProgressDialog? = null

    @LayoutRes
    abstract fun getLayout(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        View.inflate(context, getLayout(), container)

    fun showError(error: ResultError) {
        Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
    }

    fun loading(isLoading: Boolean) {
        if (isLoading) showLoading() else hideLoading()
    }

    private fun showLoading() {
        try {
            if (mProgressDialog == null) {
                mProgressDialog = ProgressDialog(activity)
                mProgressDialog?.show()
            } else {
                mProgressDialog?.show()
            }
            if (mProgressDialog?.window != null) {
                mProgressDialog?.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
            mProgressDialog?.setContentView(R.layout.progress_dialog)
            mProgressDialog?.isIndeterminate = true
            mProgressDialog?.setCancelable(false)
            mProgressDialog?.setCanceledOnTouchOutside(false)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun hideLoading() {
        try {
            mProgressDialog?.cancel()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}