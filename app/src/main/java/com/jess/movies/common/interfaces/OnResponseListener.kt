package com.jess.movies.common.interfaces

import com.jess.movies.data.ErrorData
import timber.log.Timber

/**
 * @author jess
 * @since 2020.06.17
 */
interface OnResponseListener<T> {
    fun onSuccess(response: T?)

    fun onError(
        error: ErrorData
    ) {
        Timber.d(error.toString())
    }
}