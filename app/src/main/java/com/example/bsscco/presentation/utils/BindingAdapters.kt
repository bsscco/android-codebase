package com.example.bsscco.presentation.utils

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.example.bsscco.presentation.utils.extentions.dp

@BindingAdapter("dataList")
fun <DATA> RecyclerView.submitList(dataList: List<DATA>?) {
    when {
        dataList == null || adapter == null -> return
        adapter is ListAdapter<*, *> -> {
            @Suppress("UNCHECKED_CAST")
            (adapter as ListAdapter<DATA, *>).submitList(dataList)
        }
        else -> throw Exception("submitList()가 없습니다.")
    }
}

@BindingAdapter("dataList")
fun <DATA> RecyclerView.submitList(dataList: PagedList<DATA>?) {
    when {
        dataList == null -> return
        adapter is PagedListAdapter<*, *> -> {
            @Suppress("UNCHECKED_CAST")
            (adapter as PagedListAdapter<DATA, *>).submitList(dataList)
        }
        else -> throw Exception("submitList()가 없습니다.")
    }
}

@BindingAdapter("imageUrl", "imageWidth", "imageHeight")
fun ImageView.loadImage(imageUrl: String?, width: Int, height: Int) {
    layoutParams.width = width
    layoutParams.height = height

    Glide.with(this)
            .load("https://source.unsplash.com/random")
            .override(width, height)
            .into(this)
}

@BindingAdapter("visibility")
fun View.setVisibility(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("colorSchemeColor")
fun SwipeRefreshLayout.setColorSchemeColor(@ColorInt color: Int) {
    setColorSchemeColors(color)
}

@BindingAdapter("topCornerRoundDp")
fun View.setTopCornerRound(radiusDp: Int) {
    outlineProvider = object : ViewOutlineProvider() {
        override fun getOutline(view: View, outline: Outline) {
            outline.setRoundRect(0, 0, view.width, view.height + radiusDp.dp, radiusDp.dp.toFloat())
        }
    }
    clipToOutline = true
}

@BindingAdapter("cornerRoundDp")
fun View.setCornerRound(radiusDp: Int) {
    setCornerRound(radiusDp.toFloat())
}

@BindingAdapter("corneRoundDp")
fun View.setCornerRound(radiusDp: Float) {
    outlineProvider = object : ViewOutlineProvider() {
        override fun getOutline(view: View, outline: Outline) {
            outline.setRoundRect(0, 0, view.width, view.height, radiusDp.dp.toFloat())
        }
    }
    clipToOutline = true
}