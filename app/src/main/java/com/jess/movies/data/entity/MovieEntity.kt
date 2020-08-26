package com.jess.movies.data.entity

/**
 * 영화 Response
 *
 * @author jess
 * @since 2020.06.12
 */

data class MovieEntity(
    val title: String?,
    val link: String?,
    val image: String?,
    val subtitle: String?,
    val pubDate: String?,
    val director: String?,
    val actor: String?,
    val userRating: String?
) {

    fun toEntity() {

    }
}