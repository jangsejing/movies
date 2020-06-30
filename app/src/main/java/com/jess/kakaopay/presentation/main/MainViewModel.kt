package com.jess.kakaopay.presentation.main

import androidx.lifecycle.viewModelScope
import com.jess.kakaopay.common.base.BaseViewModel
import com.jess.kakaopay.common.extension.safeScope
import com.jess.kakaopay.repository.datasource.MainDataSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author jess
 * @since 2020.06.12
 */
class MainViewModel @Inject constructor(
    private val dataSource: MainDataSource
) : BaseViewModel(dataSource) {

    val moveItems = dataSource.movieItems
    val isClear = dataSource.isClear

    override fun onCleared() {
        dataSource.onCleared()
        super.onCleared()
    }

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
