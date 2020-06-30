package com.jess.movies.presentation.live

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.jess.movies.R
import com.jess.movies.common.base.BaseActivity
import com.jess.movies.databinding.LiveActivityBinding
import com.jess.movies.presentation.detail.DetailActivity
import kotlinx.android.synthetic.main.live_activity.*
import timber.log.Timber

/**
 * @author jess
 * @since 2020.06.12
 */
class LiveActivity : BaseActivity<LiveActivityBinding, LiveViewModel>() {

    override val layoutRes = R.layout.live_activity

    override val viewModelClass = LiveViewModel::class.java

    override fun initLayout() {

    }

    override fun onCreated(savedInstanceState: Bundle?) {
        viewModel.test()
        viewModel.result.observe(this, Observer {
            Timber.d("LiveActivity $it")
        })
        bt_detail.setOnClickListener {
            startActivity(Intent(this, DetailActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Timber.d("onStart()")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("onResume()")
    }

    override fun onPause() {
        super.onPause()
    }
}
