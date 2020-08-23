package com.example.bsscco.presentation.common.viewmodel_events

import androidx.lifecycle.LiveData
import com.example.bsscco.presentation.utils.LiveEvent
import javax.inject.Inject

interface CloseActivityEvent {

    val closeActivityEvent: LiveData<Unit>
}

class CloseActivityEventImpl @Inject constructor() : CloseActivityEvent {

    val event = LiveEvent<Unit>()
    override val closeActivityEvent: LiveData<Unit>
        get() = event
}