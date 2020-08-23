package com.example.bsscco.presentation.utils.recycler_view

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

open class SimpleDiffItemCallback<T> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}