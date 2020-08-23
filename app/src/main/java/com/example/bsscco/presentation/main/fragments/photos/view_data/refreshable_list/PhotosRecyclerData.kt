package com.example.bsscco.presentation.main.fragments.photos.view_data.refreshable_list

import com.example.bsscco.presentation.common.abstracts.RecyclerData
import com.example.bsscco.presentation.main.fragments.photos.view_data.photo.PhotoViewData

sealed class PhotosRecyclerData(val type: DataType) : RecyclerData {

    enum class DataType { PHOTO, }

    data class PhotoRecyclerData(val viewData: PhotoViewData) : PhotosRecyclerData(DataType.PHOTO)
}