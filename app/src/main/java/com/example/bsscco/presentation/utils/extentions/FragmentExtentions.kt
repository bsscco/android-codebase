package com.example.bsscco.presentation.utils.extentions

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.*

// adssched19 소스 참고
inline fun <reified VM : ViewModel> Fragment.viewModelProvider(
    factory: ViewModelProvider.Factory, key: String? = null
): VM {
    val provider = ViewModelProvider(this, factory)
    return if (key == null) {
        provider.get(VM::class.java)
    } else {
        provider.get(key, VM::class.java)
    }
}

inline fun <reified VM : ViewModel> Fragment.parentViewModelProvider(
    factory: ViewModelProvider.Factory, key: String? = null
): VM {
    val provider = ViewModelProvider(parentFragment!!, factory)
    return if (key == null) {
        provider.get(VM::class.java)
    } else {
        provider.get(key, VM::class.java)
    }
}

inline fun <reified VM : ViewModel> Fragment.activityViewModelProvider(
    factory: ViewModelProvider.Factory, key: String? = null
): VM {
    val provider = ViewModelProvider(requireActivity(), factory)
    return if (key == null) {
        provider.get(VM::class.java)
    } else {
        provider.get(key, VM::class.java)
    }
}

fun Fragment.replaceFragment(@IdRes containerViewId: Int, fragment: Fragment) {
    childFragmentManager.commit { replace(containerViewId, fragment) }
}