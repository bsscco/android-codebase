package com.example.bsscco.presentation.utils.extentions

import android.util.TypedValue
import androidx.annotation.Px
import com.example.bsscco.app.App
import kotlin.math.roundToInt

val Float.dp: Int
    @Px
    get() {
        val metrics = App.instance.resources.displayMetrics
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, metrics).roundToInt()
    }