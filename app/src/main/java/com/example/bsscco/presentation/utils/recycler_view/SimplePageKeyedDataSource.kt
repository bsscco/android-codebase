package com.example.bsscco.presentation.utils.recycler_view

import androidx.paging.PageKeyedDataSource

open class SimplePageKeyedDataSource<K, V> : PageKeyedDataSource<K, V>() {

    override fun loadInitial(params: LoadInitialParams<K>, callback: LoadInitialCallback<K, V>) {}

    override fun loadAfter(params: LoadParams<K>, callback: LoadCallback<K, V>) {}

    override fun loadBefore(params: LoadParams<K>, callback: LoadCallback<K, V>) {}
}