package com.jess.movies.presentation.main.adapter

import com.jess.movies.data.BaseData
import com.jess.movies.data.MovieData

sealed class MainItem(
    open val type: Int,
    open val data: BaseData
) {

    data class NormalItem(
        override val type: Int = 0,
        override val data: MovieData.Item
    ) : MainItem(type, data)

    data class NormalSub(
        override val type: Int = 1,
        override val data: MovieData.Item
    ) : MainItem(type, data)

}