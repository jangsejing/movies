package com.jess.movies.domain.repository

import com.jess.movies.data.response.MovieResponse
import com.jess.movies.domain.repository.service.NaverService
import javax.inject.Inject

/**
 * @author jess
 * @since 2020.06.12
 */
interface NaverRepositoryV2 {
    val displayCount: Int

    suspend fun getMovie(query: String?, start: Int = 1): MovieResponse
}

class NaverRepositoryImplV2 @Inject constructor(
    private val service: NaverService
) : NaverRepositoryV2 {

    companion object {
        const val DISPLAY_COUNT = 20
    }

    override val displayCount: Int get() = DISPLAY_COUNT

    override suspend fun getMovie(query: String?, start: Int) = service.getMoviesV2(query, start)
}
