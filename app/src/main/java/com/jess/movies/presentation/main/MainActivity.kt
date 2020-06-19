package com.jess.movies.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.jess.movies.R
import com.jess.movies.common.base.BaseActivity
import com.jess.movies.common.base.BaseRecyclerViewAdapter
import com.jess.movies.common.util.DeviceUtils
import com.jess.movies.data.MovieData
import com.jess.movies.databinding.MainActivityBinding
import com.jess.movies.databinding.MainItemBinding
import com.jess.movies.presentation.detail.DetailActivity
import com.jess.movies.presentation.detail.DetailActivity.Companion.EXTRA_MOVIE_DATA
import kotlinx.android.synthetic.main.main_activity.*

/**
 * @author jess
 * @since 2020.06.12
 */
class MainActivity : BaseActivity<MainActivityBinding, MainViewModel>() {

    override val layoutRes = R.layout.main_activity

    override val viewModelClass = MainViewModel::class.java

    override fun initLayout() {
        rv_movie.run {

            adapter = object : BaseRecyclerViewAdapter<MovieData.Item, MainItemBinding>(
                R.layout.main_item
            ) {

            }.apply {
                setOnItemClickListener { view, item ->
                    val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
                        putExtra(EXTRA_MOVIE_DATA, item)
                    }
                    startActivity(intent)
                }
            }

            setOnPagingListener {
                viewModel.getNextPage()
            }

            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(
                    view: RecyclerView,
                    newState: Int
                ) {
                    super.onScrollStateChanged(view, newState)
                    if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                        DeviceUtils.hideKeyboard(view)
                    }
                }
            })
        }

        // 텍스트 리턴
        cv_search.seOnTextListener {
            viewModel.getMovie(it)
        }
    }

    override fun onCreated(savedInstanceState: Bundle?) {

    }

    override fun onResume() {
        super.onResume()
        cv_search.onResume()
    }

    override fun onPause() {
        cv_search.onPause()
        super.onPause()
    }
}
