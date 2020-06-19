package com.jess.movies.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jess.movies.common.base.BaseDataSource

abstract class BaseDataSourceImpl(

) : BaseDataSource {

    internal val _isRequest = MutableLiveData<Boolean>()
    override val isRequest: LiveData<Boolean> get() = _isRequest

}