package com.jess.movies.common.extension

import android.webkit.WebView

/**
 * WebView URL Load
 */
fun WebView.loadWeb(url: String?) {
    if (url.isNullOrEmpty()) {
        return
    }
    this.loadUrl(url)
}