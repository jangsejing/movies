package com.jess.movies.presentation.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jess.movies.BR
import com.jess.movies.R

class MainAdapter : ListAdapter<MainItem, MainAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun getItemViewType(position: Int): Int = getItem(position).type

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val layoutId = when (viewType) {
            0 -> R.layout.main_item
            else -> R.layout.main_item_sub
        }
        return ViewHolder(createViewDataBinding(parent, layoutId))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun createViewDataBinding(parent: ViewGroup, layoutId: Int): ViewDataBinding {
        return DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layoutId,
            parent,
            false
        )
    }

    class ViewHolder(
        private val viewDataBinding: ViewDataBinding
    ) : RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bind(item: MainItem) {
            viewDataBinding.run {
                setVariable(BR.item, item.data)
                viewDataBinding.executePendingBindings()
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MainItem>() {

            override fun areItemsTheSame(
                oldItem: MainItem,
                newItem: MainItem
            ): Boolean {
                return oldItem == newItem
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(
                oldItem: MainItem,
                newItem: MainItem
            ): Boolean {
                return oldItem.data == newItem.data
            }
        }
    }
}