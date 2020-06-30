package com.jess.movies.presentation.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.jess.movies.R
import com.jess.movies.common.base.BaseActivity
import com.jess.movies.data.MovieData
import com.jess.movies.databinding.DetailActivityBinding
import kotlinx.android.synthetic.main.detail_activity.*

/**
 * @author jess
 * @since 2020.06.12
 */
class DetailActivity : BaseActivity<DetailActivityBinding, DetailViewModel>(),
    View.OnClickListener {

    companion object {
        const val EXTRA_MOVIE_DATA = "EXTRA_MOVIE_DATA"
    }

    override val layoutRes = R.layout.detail_activity

    override val viewModelClass = DetailViewModel::class.java

    private val movieData by lazy {
        intent?.getParcelableExtra(EXTRA_MOVIE_DATA) as? MovieData.Item
    }

    override fun initLayout() {
        iv_info.setOnClickListener(this)
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        viewModel.setData(movieData)
    }

    override fun initDataBinding() {
        super.initDataBinding()
        viewModel.detailUrl.observe(this, Observer {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(it)
            )
            startActivity(intent)
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_info -> viewModel.moveDetailInfo()
        }
    }
}
