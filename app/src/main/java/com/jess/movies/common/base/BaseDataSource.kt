package com.jess.movies.common.base

import com.jess.movies.di.DispatcherProvider
import kotlinx.coroutines.cancel

abstract interface BaseDataSource {

    val dispatcher: DispatcherProvider

    fun onCleared() {
        dispatcher.run {
            io().cancel()
            main().cancel()
        }
    }
}