package com.jess.movies.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jess.movies.common.base.BaseViewModel
import com.jess.movies.data.MovieData
import javax.inject.Inject

/**
 * @author jess
 * @since 2020.06.12
 */
class DetailViewModel @Inject constructor(

) : BaseViewModel() {

    private val _item = MutableLiveData<MovieData.Item>()
    val item: LiveData<MovieData.Item> = _item

    fun setData(item: MovieData.Item?) {
        item?.let {
            _item.value = item
        }
    }
}
