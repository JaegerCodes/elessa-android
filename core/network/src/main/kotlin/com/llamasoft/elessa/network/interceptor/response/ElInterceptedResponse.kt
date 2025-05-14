package com.llamasoft.elessa.network.interceptor.response

import okhttp3.Headers
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.IOException

sealed class ElInterceptedResponse<out T> {
    data class Success<T>(
        val body: T?,
        val code: Int,
        val headers: Headers,
        val raw: Response<T>
    ) : ElInterceptedResponse<T>()

    data class ApiError(
        val errorBody: ResponseBody?,
        val code: Int,
        val headers: Headers,
        val raw: Response<*>
    ) : ElInterceptedResponse<Nothing>()

    data class NetworkError(val error: IOException) : ElInterceptedResponse<Nothing>()
    data class UnknownError(val error: Throwable) : ElInterceptedResponse<Nothing>()
}
