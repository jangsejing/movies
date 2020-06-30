package com.jess.movies.common.base

import androidx.lifecycle.ViewModel
import timber.log.Timber

/**
 * @author jess
 * @since 2020.06.12
 */
abstract class BaseViewModel : ViewModel() {

    open var baseDataSource: BaseDataSource? = null
    val onProgress by lazy { baseDataSource?.isRequest }

    override fun onCleared() {
        Timber.d("onCleared()")
        baseDataSource?.onCleared()
        super.onCleared()
    }
}