package com.example.mvvmclean.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmclean.R
import com.example.mvvmclean.base.BaseRecyclerViewAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

object BindingUtils {
    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @BindingAdapter("adapter")
    fun <T> setRecyclerViewData(recyclerView: RecyclerView, items: List<T>?) {
        items?.let {
            (recyclerView.adapter as? BaseRecyclerViewAdapter<T>)?.apply {
                clearItems()
                addItems(items)
            }
        }
    }

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: String?) {
        if(url!=null && url.isNotEmpty()){
            Glide.with(imageView.context)
                .load(url)
                .into(imageView)
        }else
            imageView.setImageResource(R.drawable.ic_image_not_found)

    }

    @JvmStatic
    @BindingAdapter("imageUrlCrop")
    fun setImageUrlCrop(imageView: ImageView, url: String?) {
        if(url!=null && url.isNotEmpty()){
            Glide.with(imageView.context)
                .load(url)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView)
        }else {
            Glide.with(imageView.context)
                .load(R.drawable.ic_image_not_found)
                .apply(RequestOptions.circleCropTransform())
                .into(imageView)
        }
    }
}