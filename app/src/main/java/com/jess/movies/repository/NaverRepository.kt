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
    suspend fun getMovie(query: String?, start: Int): Response<MovieData>
}

class NaverRepositoryImpl @Inject constructor(
    private val service: NaverService
) : NaverRepository {

    override suspend fun getMovie(query: String?, start: Int): Response<MovieData> =
        service.getMovies(query, start)

}
