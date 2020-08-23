package com.example.bsscco.presentation.common.viewmodel_events

import androidx.lifecycle.LiveData
import com.example.bsscco.presentation.utils.LiveEvent
import javax.inject.Inject

interface BackPressEvent {

    val backPressEvent: LiveData<Unit>
}

class BackPressEventImpl @Inject constructor() : BackPressEvent {

    val event = LiveEvent<Unit>()
    override val backPressEvent: LiveData<Unit>
        get() = event
}