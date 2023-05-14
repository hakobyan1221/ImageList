package com.test.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("android:errorText")
fun setError(inputLayout: TextInputLayout, errorMessage: String?) {
    inputLayout.error = if (errorMessage.isNullOrEmpty()) {
        null
    } else errorMessage
}

@BindingAdapter("android:imagePath")
fun loadImage(imageView: ImageView, path: String?) {
    Glide.with(imageView).load(path).into(imageView)
}
