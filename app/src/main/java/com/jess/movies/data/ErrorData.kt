package com.jess.movies.data

/**
 * 통신 에러
 *
 * @author jess
 * @since 2020.06.17
 */
data class ErrorData(
    val errorMessage: String?,
    val errorCode: String?
)