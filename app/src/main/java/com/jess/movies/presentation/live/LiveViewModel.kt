package com.jess.movies.presentation.live

import androidx.lifecycle.viewModelScope
import com.jess.movies.common.base.BaseDataSource
import com.jess.movies.common.base.BaseViewModel
import com.jess.movies.common.extension.safeScope
import com.jess.movies.domain.datasource.LiveDataSource
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author jess
 * @since 2020.06.12
 */
class LiveViewModel @Inject constructor(
    private val dataSource: LiveDataSource
) : BaseViewModel() {

    override var baseDataSource: BaseDataSource? = dataSource
    val result = dataSource.result

    fun test() {
        viewModelScope.safeScope().launch {
            dataSource.start()
        }
    }

}
