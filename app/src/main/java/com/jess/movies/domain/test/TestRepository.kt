package com.jess.movies.domain.test

import android.util.Log

class TestRepository(
    private val testSingleton: TestSingleton,
    test1: Test1,
    test2: Test2,
    test3: Test3
) {

    fun log() {
        Log.d("jess", "log TestRepository")
        testSingleton.log()
    }



}