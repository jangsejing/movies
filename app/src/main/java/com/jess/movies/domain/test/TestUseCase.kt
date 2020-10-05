package com.jess.movies.domain.test

import android.util.Log

class TestUseCase (
    private val testRepository: TestRepository
) {

    fun log() {
        Log.d("jess", "log TestUseCase")
        testRepository.log()
    }
}