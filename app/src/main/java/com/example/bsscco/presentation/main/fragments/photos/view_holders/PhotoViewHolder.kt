package com.example.bsscco.presentation.main.fragments.photos.view_holders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bsscco.databinding.PhotoBinding
import com.example.bsscco.presentation.main.fragments.photos.view_data.photo.PhotoViewData
import com.example.bsscco.presentation.main.fragments.photos.view_events.PhotoEventListener

class PhotoViewHolder(
        private val binding: PhotoBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(
                parent: ViewGroup,
                eventListener: PhotoEventListener
        ) = LayoutInflater.from(parent.context)
                .let { inflater -> PhotoBinding.inflate(inflater, parent, false) }
                .also { binding -> binding.eventListener = eventListener }
                .let { binding -> PhotoViewHolder(binding) }
    }

    fun bind(viewData: PhotoViewData) {
        binding.viewData = viewData
        binding.executePendingBindings()
    }
}