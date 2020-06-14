package com.jess.movies.common.bindingadapter

import androidx.databinding.BindingAdapter
import com.jess.movies.common.extension.addItems
import com.jess.movies.common.view.PagingRecyclerView

/**
 * @author jess
 * @since 2020.06.12
 */

/**
 * RecyclerView Adapter
 *
 * @param items
 * @param isClear
 */
@BindingAdapter(value = ["items", "isClear"], requireAll = false)
fun PagingRecyclerView.addItems(
    items: List<Any>?,
    isClear: Boolean = true
) {
    this.addItems(items, isClear)
}

/**
 * RecyclerView Adapter
 *
 * @param items
 */
@BindingAdapter("submitList")
fun PagingRecyclerView.submitList(
    items: List<Any>?
) {
    this.addItems(items)
}