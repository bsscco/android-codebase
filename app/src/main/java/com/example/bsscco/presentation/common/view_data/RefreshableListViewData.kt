package com.example.bsscco.presentation.common.view_data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.bsscco.presentation.common.abstracts.RecyclerData
import com.example.bsscco.presentation.common.enums.LoadingStatus

data class RefreshableListViewData(
    val loadingStatus: LiveData<LoadingStatus>,
    val pagedList: LiveData<PagedList<RecyclerData>>
)