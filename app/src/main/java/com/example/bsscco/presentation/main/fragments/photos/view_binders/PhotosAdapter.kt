package com.example.bsscco.presentation.main.fragments.photos.view_binders

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.bsscco.presentation.main.fragments.photos.view_data.refreshable_list.PhotosRecyclerData
import com.example.bsscco.presentation.main.fragments.photos.view_events.PhotoEventListener
import com.example.bsscco.presentation.main.fragments.photos.view_holders.PhotoViewHolder
import com.example.bsscco.presentation.utils.recycler_view.SimpleDiffItemCallback

class PhotosAdapter(
    private val photoEventListener: PhotoEventListener
) : PagedListAdapter<PhotosRecyclerData, RecyclerView.ViewHolder>(SimpleDiffItemCallback()) {

    override fun getItemViewType(position: Int): Int {
        return currentList?.get(position)?.type?.ordinal ?: -1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            PhotosRecyclerData.DataType.PHOTO.ordinal -> PhotoViewHolder.from(parent, photoEventListener)
            else -> throw ClassNotFoundException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val recyclerData = getItem(position)
        when {
            holder is PhotoViewHolder && recyclerData is PhotosRecyclerData.PhotoRecyclerData -> holder.bind(recyclerData.viewData)
        }
    }
}