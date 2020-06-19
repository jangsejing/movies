package com.jess.movies.repository

import com.jess.movies.data.MovieData
import com.jess.movies.repository.service.NaverService
import retrofit2.Response
import javax.inject.Inject

/**
 * @author jess
 * @since 2020.06.12
 */
interface NaverRepository {
    val displayCount: Int
    suspend fun getMovie(query: String?, start: Int): Response<MovieData>
}

class NaverRepositoryImpl @Inject constructor(
    private val service: NaverService
) : NaverRepository {

    companion object {
        const val DISPLAY_COUNT = 20
    }

    override val displayCount: Int get() = DISPLAY_COUNT

    override suspend fun getMovie(query: String?, start: Int) = service.getMovies(query, start)
}
