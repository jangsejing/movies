package com.jess.movies.data.response

import android.os.Parcelable
import com.jess.movies.data.entity.MovieEntity
import kotlinx.android.parcel.Parcelize

/**
 * 영화 Response
 *
 * @author jess
 * @since 2020.06.12
 */
data class MovieResponse(
    val lastBuildDate: String?,
    val total: Int,
    val start: Int,
    val display: Int,
    val items: List<Item>?
) {

    @Parcelize
    data class Item(
        val title: String?,
        val link: String?,
        val image: String?,
        val subtitle: String?,
        val pubDate: String?,
        val director: String?,
        val actor: String?,
        val userRating: String?
    ) : Parcelable {
        fun toEntity(): MovieEntity {
            return MovieEntity(
                title = title,
                link = link,
                image = image,
                subtitle = subtitle,
                pubDate = pubDate,
                director = director,
                actor = actor,
                userRating = userRating
            )
        }
    }

    /**
     * 시작 페이지
     *
     * @param displayCount 불러올 페이지 수
     */
    fun getStartNumber(displayCount: Int) = start + displayCount

    /**
     * 다음 페이지 여부
     */
    fun isMorePage() = (start + display) <= total


}