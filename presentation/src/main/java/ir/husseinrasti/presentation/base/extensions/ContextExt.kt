package ir.husseinrasti.presentation.base.extensions

import android.view.View
import android.view.animation.AlphaAnimation
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


fun View.fadeIn(isAnimation: Boolean = true, time: Long = 300) {
    if (isAnimation) {
        this.startAnimation(AlphaAnimation(0F, 1F).apply {
            duration = time

        })
    }
    this.visibility = View.VISIBLE
}

fun View.fadeOut(isAnimation: Boolean = true) {
    if (isAnimation) {
        this.startAnimation(AlphaAnimation(1F, 0F).apply {
            duration = 300
        })
    }
    this.visibility = View.GONE

}