package com.jess.movies.data

/**
 * 통신 에러
 */
data class ErrorData(
    val status: Int?,
    val errorMessage: String?,
    val errorCode: String?
)