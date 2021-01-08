package ir.husseinrasti.presentation.base.extensions

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    context?.apply {
        Toast.makeText(this, message, duration).show()
    }
}

fun Fragment.showToast(@StringRes message: Int, duration: Int = Toast.LENGTH_SHORT) {
    showToast(resources.getString(message), duration)
}
