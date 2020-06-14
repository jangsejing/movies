package com.jess.movies.common.base

sealed class BaseStatus {
    class Toast(val message: String) : BaseStatus()
    class Progress(val isShow: Boolean) : BaseStatus()
}