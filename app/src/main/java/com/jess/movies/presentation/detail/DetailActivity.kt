package com.jess.movies.presentation.detail

import android.os.Bundle
import com.jess.movies.R
import com.jess.movies.common.base.BaseActivity
import com.jess.movies.data.MovieData
import com.jess.movies.databinding.DetailActivityBinding

/**
 * @author jess
 * @since 2020.06.12
 */
class DetailActivity : BaseActivity<DetailActivityBinding, DetailViewModel>() {

    companion object {
        const val EXTRA_MOVIE_DATA = "EXTRA_MOVIE_DATA"
    }

    override val layoutRes = R.layout.detail_activity

    override val viewModelClass = DetailViewModel::class.java

    private val movieData by lazy {
        intent?.getSerializableExtra(EXTRA_MOVIE_DATA) as? MovieData.Item
    }

    override fun initLayout() {

    }

    override fun onCreated(savedInstanceState: Bundle?) {
        viewModel.setData(movieData)
    }
}
