package com.jess.movies.domain.usecase

import com.jess.movies.data.entity.MovieEntity
import com.jess.movies.domain.repository.NaverRepositoryV2

/**
 * 영화 검색 Use Case
 *
 * @author jess
 * @since 2020.08.26
 */
class MovieSearchUseCase(private val repository: NaverRepositoryV2) {

    suspend operator fun invoke(query: String?): List<MovieEntity>? {
        repository.getMovie(query).run {
            this.items.run {
                return this?.run {
                    this.map { it.toEntity() }
                }
            }
        }
        return null
    }

}