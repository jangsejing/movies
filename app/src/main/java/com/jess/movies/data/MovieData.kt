package com.jess.movies.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * 영화 Response
 *
 * @author jess
 * @since 2020.06.12
 */
data class MovieData(
    val lastBuildDate: String?,
    val total: Int,
    val start: Int,
    val display: Int,
    val items: List<Item>?
) {

    @Parcelize
    data class Item(
        var style: Int,
        val title: String?,
        val link: String?,
        val image: String?,
        val subtitle: String?,
        val pubDate: String?,
        val director: String?,
        val actor: String?,
        val userRating: String?
    ) : BaseData(), Parcelable

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