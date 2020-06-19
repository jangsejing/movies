package com.jess.movies.common.base

import androidx.lifecycle.LiveData
import com.jess.movies.di.provider.DispatcherProvider
import kotlinx.coroutines.cancel

interface BaseDataSource {

    val isRequest: LiveData<Boolean>
    val dispatcher: DispatcherProvider

    fun onCleared() {
        dispatcher.run {
            io().cancel()
            main().cancel()
        }
    }
}