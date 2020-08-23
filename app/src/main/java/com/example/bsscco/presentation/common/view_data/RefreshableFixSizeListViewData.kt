package com.example.bsscco.presentation.common.view_data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bsscco.presentation.common.abstracts.RecyclerData
import com.example.bsscco.presentation.common.enums.LoadingStatus

interface RefreshableFixSizeListViewData {
    val loadingStatus: LiveData<LoadingStatus>
    val dataList: LiveData<List<RecyclerData>>
}

data class RefreshableFixSizeListViewDataImpl(
    override val loadingStatus: MutableLiveData<LoadingStatus>,
    override val dataList: MutableLiveData<List<RecyclerData>>
) : RefreshableFixSizeListViewData