package com.jess.movies.presentation.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.jess.movies.R
import com.jess.movies.common.base.BaseActivity
import com.jess.movies.common.extension.createActivityViewModel
import com.jess.movies.common.util.DeviceUtils
import com.jess.movies.databinding.MainActivityBinding
import com.jess.movies.domain.test.TestViewModel
import com.jess.movies.presentation.main.adapter.MainAdapter
import kotlinx.android.synthetic.main.main_activity.*

/**
 * @author jess
 * @since 2020.06.12
 */
class MainActivity : BaseActivity<MainActivityBinding, MainViewModel>() {

    override val layoutRes = R.layout.main_activity

    override val viewModelClass = MainViewModel::class.java

    // AAC ViewModel
    private val viewModel2 by lazy(LazyThreadSafetyMode.NONE) {
        createActivityViewModel(viewModelFactory, MainViewModelV2::class.java)
    }

    private val testViewModel: TestViewModel by viewModels { viewModelFactory }

    override fun initLayout() {
        rv_movie.run {

//            adapter = object : BaseRecyclerViewAdapter<MovieData.Item, MainItemBinding>(
//                R.layout.main_item
//            ) {
//
//                override fun getItemViewType(position: Int): Int {
//                    return list[position].style
//                }
//
//                override fun onCreateViewHolder(
//                    parent: ViewGroup,
//                    viewType: Int
//                ): BaseViewHolder<MovieData.Item> {
//                    val layoutId = when (viewType) {
//                        0 -> R.layout.main_item
//                        else -> R.layout.main_item_sub
//                    }
//                    return createViewHolder(createViewDataBinding(parent, layoutId))
//                }
//
//            }.apply {
//                setOnItemClickListener { view, item ->
//                    val intent = Intent(this@MainActivity, DetailActivity::class.java).apply {
//                        putExtra(EXTRA_MOVIE_DATA, item)
//                    }
//                    startActivity(intent)
//                }
//            }

            adapter = MainAdapter(vm)

            setOnPagingListener {
//                vm.getNextPage()
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
            vm.getMovie(it)
        }
    }

    override fun onCreated(savedInstanceState: Bundle?) {

        vm.list.observe(this, Observer {
            val adapter = rv_movie.adapter as MainAdapter
            adapter.submitList(it)
        })

        testViewModel.log()
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
