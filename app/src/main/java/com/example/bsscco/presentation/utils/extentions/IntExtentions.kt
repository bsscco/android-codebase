package com.example.bsscco.presentation.utils.extentions

import androidx.annotation.Px

val Int.dp: Int
    @Px
    get() = this.toFloat().dp