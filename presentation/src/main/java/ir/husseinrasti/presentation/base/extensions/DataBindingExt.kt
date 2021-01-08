package ir.husseinrasti.presentation.base.extensions

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:imageUrl")
fun loadImage(view: ImageView, url: String?) = view.apply {
    if (url.isNullOrEmpty()) {
        visibility = View.GONE
    } else {
        visibility = View.VISIBLE
        Glide.with(this)
            .load(url)
            .placeholder(circularProgressDrawable())
            .into(this)
    }
}
