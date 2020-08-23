package com.example.bsscco.presentation.common.viewmodel_events

import androidx.lifecycle.LiveData
import com.example.bsscco.presentation.common.viewmodel_events.PushPhotoFragmentEvent.EventData
import com.example.bsscco.presentation.utils.LiveEvent
import javax.inject.Inject

interface PushPhotoFragmentEvent {

    data class EventData(val photoId: Int)

    val pushPhotoFragmentEvent: LiveData<EventData>
}

class PushPhotoFragmentEventImpl @Inject constructor() : PushPhotoFragmentEvent {

    val event = LiveEvent<EventData>()
    override val pushPhotoFragmentEvent: LiveData<EventData>
        get() = event
}