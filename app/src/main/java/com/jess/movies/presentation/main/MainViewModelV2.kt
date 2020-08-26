package com.jess.movies.presentation.main

import androidx.lifecycle.viewModelScope
import com.jess.movies.common.base.BaseDataSource
import com.jess.movies.common.base.BaseViewModel
import com.jess.movies.domain.datasource.MainDataSource
import com.jess.movies.domain.repository.NaverRepository
import com.jess.movies.domain.repository.NaverRepositoryV2
import com.jess.movies.domain.usecase.MovieSearchUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * UseCase 사용
 * @author jess
 * @since 2020.08.26
 */
class MainViewModelV2 @Inject constructor(
    private val repository: NaverRepositoryV2
) : BaseViewModel() {

    private val movieSearchUseCase by lazy {
        MovieSearchUseCase(repository)
    }

    /**
     * 영화 검색
     */
    fun getMovie(query: String?) {
        viewModelScope.launch {
            delay(500)
            movieSearchUseCase(query).run {
                Timber.d(this.toString())
            }
        }
    }
}
