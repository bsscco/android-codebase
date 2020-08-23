package com.example.bsscco.presentation.utils

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import org.jetbrains.annotations.NotNull
import java.util.concurrent.atomic.AtomicBoolean

/**
 * 이벤트 발생 시 Observer.onChanged() 콜백이 딱 한 번만 호출되도록 강제하는 LiveData
 * 예) LiveData의 상태가 Inactive 였다가 다시 Active로 돌아왔을 때 불필요한 onChanged() 콜백 호출을 막아줍니다.
 *
 * @author bsscco
 * @see
 * <a href="https://github.com/googlesamples/android-architecture/blob/dev-todo-mvvm-live/todoapp/app/src/main/java/com/example/android/architecture/blueprints/todoapp/SingleLiveEvent.java">Google Samples / SingleLiveEvent</a>
 * <a href="https://github.com/hadilq/LiveEvent">Github hadilq의 LiveEvent</a>
 */
open class LiveEvent<T> : MutableLiveData<T>() {

    private val observerWrappers = ArrayList<ObserverWrapper<in T>>()

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        val wrapper = ObserverWrapper(observer).also { observerWrappers.add(it) }
        super.observe(owner, wrapper)
    }

    override fun observeForever(observer: Observer<in T>) {
        val wrapper = ObserverWrapper(observer).also { observerWrappers.add(it) }
        super.observeForever(wrapper)
    }

    override fun removeObserver(@NotNull observer: Observer<in T>) {
        if (observer is ObserverWrapper) {
            observerWrappers.remove(observer)
        }
        super.removeObserver(observer)
    }

    @MainThread
    override fun setValue(t: T?) {
        observerWrappers.forEach { it.pending.set(true) }
        super.setValue(t)
    }

    /**
     * Used for cases where T is Void, to make calls cleaner.
     */
    @MainThread
    fun call() {
        value = null
    }

    private class ObserverWrapper<T>(val observer: Observer<T>) : Observer<T> {
        var pending = AtomicBoolean(false)

        override fun onChanged(t: T?) {
            if (pending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        }
    }
}