package com.jess.movies.presentation.main

import androidx.lifecycle.viewModelScope
import com.jess.movies.common.base.BaseDataSource
import com.jess.movies.common.base.BaseViewModel
import com.jess.movies.common.extension.safeScope
import com.jess.movies.domain.datasource.MainDataSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author jess
 * @since 2020.06.12
 */
class MainViewModel @Inject constructor(
    private val dataSource: MainDataSource
) : BaseViewModel() {

    override var baseDataSource: BaseDataSource? = dataSource

    val moveItems = dataSource.movieItems
    val list = dataSource.list
    val isClear = dataSource.isClear

    /**
     * 영화 검색
     */
    fun getMovie(query: String?) {
        viewModelScope.safeScope().launch {
            delay(500)
            dataSource.getMovieData(query)
        }
    }

    /**
     * 영화 다음 페이지 검색
     */
    fun getNextPage() {
        viewModelScope.safeScope().launch {
            dataSource.getNextPage()
        }
    }
}
