package com.jess.movies.common.view

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import timber.log.Timber

class PagingRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    companion object {
        const val VISIBLE_THRESHOLD = 3
    }

    private var listener: (() -> Unit)? = null
    private var isLoading = false

    init {
        initialize()
    }

    fun setOnPagingListener(listener: (() -> Unit)?) {
        this.listener = listener
    }

    private fun initialize() {

        addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {

            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                layoutManager?.let { layoutManager ->
                    val manager = layoutManager as LinearLayoutManager
                    val totalItemCount = manager.itemCount
                    val visibleItemCount = manager.childCount
                    val lastVisibleItemPosition = manager.findLastVisibleItemPosition()

                    if (!isLoading
                        && (visibleItemCount + lastVisibleItemPosition + VISIBLE_THRESHOLD >= totalItemCount)
                    ) {
                        Timber.d(">> OnPaging")
                        isLoading = true
                        listener?.invoke()
                    }
                }
            }
        })
    }

    override fun setAdapter(adapter: Adapter<*>?) {
        adapter?.registerAdapterDataObserver(object :
            RecyclerView.AdapterDataObserver() {
            override fun onChanged() {
                super.onChanged()
                isLoading = false
            }
        })
        super.setAdapter(adapter)
    }
}
