package com.example.bsscco.presentation.main.fragments.photo.view_binders

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bsscco.presentation.main.fragments.photo.view_data.refreshable_list.PhotoRecyclerData
import com.example.bsscco.presentation.main.fragments.photo.view_holders.HeaderViewHolder
import com.example.bsscco.presentation.utils.recycler_view.SimpleDiffItemCallback

class PhotoAdapter() : ListAdapter<PhotoRecyclerData, RecyclerView.ViewHolder>(SimpleDiffItemCallback()) {

    override fun getItemViewType(position: Int): Int {
        return currentList[position].type.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            PhotoRecyclerData.DataType.HEADER.ordinal -> HeaderViewHolder.from(parent)
            else -> throw ClassNotFoundException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val recyclerData = getItem(position)
        when {
            holder is HeaderViewHolder && recyclerData is PhotoRecyclerData.HeaderRecyclerData -> holder.bind(recyclerData.viewData)
        }
    }
}