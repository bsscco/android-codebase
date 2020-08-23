package com.example.bsscco.presentation.main.fragments.photo.view_data.refreshable_list

import com.example.bsscco.presentation.common.abstracts.RecyclerData
import com.example.bsscco.presentation.main.fragments.photos.view_data.photo.PhotoViewData

sealed class PhotoRecyclerData(val type: DataType) : RecyclerData {

    enum class DataType { HEADER, }

    data class HeaderRecyclerData(val viewData: PhotoViewData) : PhotoRecyclerData(DataType.HEADER)
}