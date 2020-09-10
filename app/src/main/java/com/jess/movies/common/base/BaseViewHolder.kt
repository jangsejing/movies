package com.jess.movies.common.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.jess.movies.BR
import com.jess.movies.common.util.tryCatch

/**
 * @author jess
 * @since 2020.06.12
 */
open class BaseViewHolder<T : Any?>(
    private val viewDataBinding: ViewDataBinding
) : RecyclerView.ViewHolder(viewDataBinding.root) {

    open fun onBind(item: T?) {
        tryCatch {
            viewDataBinding.run {
                setVariable(BR.item, item)
                viewDataBinding.executePendingBindings()
            }
        }
    }
}