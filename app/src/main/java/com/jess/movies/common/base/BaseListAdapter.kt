package com.jess.movies.common.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jess.movies.common.extension.addCircleRipple
import com.jess.movies.common.extension.addRipple

internal abstract class BaseListAdapter<ITEM : Any>(
    @LayoutRes private val layoutId: Int = 0,
    diffCallback: DiffUtil.ItemCallback<ITEM>
) : ListAdapter<ITEM, BaseViewHolder<ITEM>>(diffCallback) {

    private var itemClickListener: ((View, ITEM?) -> Unit)? = null
    private var isCircleRipple: Boolean = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ITEM> {

        require(layoutId > 0) { "Empty Layout Resource" }

        val dataBinding = createViewDataBinding(parent)
        val viewHolder = createViewHolder(dataBinding, viewType)

        dataBinding.run {

            // onClick
            itemClickListener?.let { listener ->
                root.run {
                    if (isCircleRipple) addCircleRipple() else addRipple()
                    setOnClickListener { view ->
                        if (viewHolder.adapterPosition != RecyclerView.NO_POSITION) {
                            listener.invoke(view, getItem(viewHolder.adapterPosition))
                        }
                    }
                }
            }
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ITEM>, position: Int) {
        holder.onBind(getItem(position))
    }

    /**
     * 아이템 클릭 리스너
     *
     * @param listener
     * @param isCircleRipple
     */
    open fun setOnItemClickListener(
        isCircleRipple: Boolean = false,
        listener: ((View, ITEM?) -> Unit)?
    ) {
        this.itemClickListener = listener
        this.isCircleRipple = isCircleRipple
    }

    open fun createViewDataBinding(parent: ViewGroup): ViewDataBinding {
        return DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layoutId,
            parent,
            false
        )
    }

    open fun createViewHolder(dataBinding: ViewDataBinding, viewType: Int): BaseViewHolder<ITEM> {
        return BaseViewHolder(dataBinding)
    }
}
