package com.jess.movies.domain.test

import android.util.Log
import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * @author jess
 * @since 2020.06.12
 */
class TestViewModel @Inject constructor(
    private val testUseCase: TestUseCase
) : ViewModel() {


    fun log() {
        Log.d("jess", "log TestViewModel")
        testUseCase.log()
    }

}
