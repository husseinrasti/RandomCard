package ir.husseinrasti.presentation.base.extensions

import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import ir.husseinrasti.presentation.R

fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    context?.apply {
        Toast.makeText(this, message, duration).show()
    }
}

fun Fragment.showToast(@StringRes message: Int, duration: Int = Toast.LENGTH_SHORT) {
    showToast(resources.getString(message), duration)
}

fun View.circularProgressDrawable(): CircularProgressDrawable {
    val circularProgressDrawable = CircularProgressDrawable(this.context)
    circularProgressDrawable.strokeWidth = 3f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.setColorSchemeColors(this.resources.getColor(R.color.teal_700))
    circularProgressDrawable.start()
    return circularProgressDrawable
}
