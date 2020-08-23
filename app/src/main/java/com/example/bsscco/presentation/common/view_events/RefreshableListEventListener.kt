package com.example.bsscco.presentation.common.view_events

import com.example.bsscco.presentation.common.annotations.OnViewEvent

interface RefreshableListEventListener {
    @OnViewEvent
    fun onPullToRefresh()
}