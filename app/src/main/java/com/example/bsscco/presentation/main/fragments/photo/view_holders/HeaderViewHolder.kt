package com.example.bsscco.presentation.main.fragments.photo.view_holders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bsscco.databinding.PhotoBinding
import com.example.bsscco.presentation.main.fragments.photos.view_data.photo.PhotoViewData

class HeaderViewHolder(
        private val binding: PhotoBinding
) : RecyclerView.ViewHolder(binding.root) {

    companion object {
        fun from(
                parent: ViewGroup
        ) = LayoutInflater.from(parent.context)
                .let { inflater -> PhotoBinding.inflate(inflater, parent, false) }
                .let { binding -> HeaderViewHolder(binding) }
    }

    fun bind(viewData: PhotoViewData) {
        binding.viewData = viewData
        binding.executePendingBindings()
    }
}