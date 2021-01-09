package ir.husseinrasti.presentation.base.extensions

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import ir.husseinrasti.presentation.R

@BindingAdapter("app:imageUrl")
fun loadImage(view: ImageView, url: String?) = view.apply {
    if (url.isNullOrEmpty()) {
        fadeOut()
    } else {
        fadeIn()
        Glide.with(this)
            .load(url)
            .placeholder(circularProgressDrawable())
            .into(this)
    }
}

@BindingAdapter("app:setImage")
fun setImage(view: ImageView, code: Int) = view.apply {
    when (code) {
        0 -> {
            setImageResource(R.drawable.ic_image)
        }
        1 -> {
            setImageResource(R.drawable.ic_vibrate)
        }
        2 -> {
            setImageResource(R.drawable.ic_sound)
        }
    }
}
