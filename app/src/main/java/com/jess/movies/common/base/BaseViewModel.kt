package com.jess.movies.common.base

import androidx.lifecycle.ViewModel
import com.jess.movies.repository.datasource.MainDataSource

/**
 * @author jess
 * @since 2020.06.12
 */
abstract class BaseViewModel(
    dataSource: MainDataSource? = null
) : ViewModel() {
    val onProgress = dataSource?.isRequest
}