package com.llamasoft.elessa.network.interceptor.response

import okhttp3.Request
import okhttp3.ResponseBody
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException

internal class ElInterceptedResponseCall<S : Any>(
    private val delegate: Call<S>,
    private val converter: Converter<ResponseBody, S>
) : Call<ElInterceptedResponse<S>> {

    override fun enqueue(callback: Callback<ElInterceptedResponse<S>>) {
        delegate.enqueue(object : Callback<S> {
            override fun onResponse(call: Call<S>, response: Response<S>) {
                val result = if (response.isSuccessful) {
                    ElInterceptedResponse.Success(
                        response.body(),
                        response.code(),
                        response.headers(),
                        response
                    )
                } else {
                    val parsedError = try {
                        val errorBody = response.errorBody()
                        ElInterceptedResponse.ApiError(
                            errorBody,
                            response.code(),
                            response.headers(),
                            response
                        )
                    } catch (e: Exception) {
                        ElInterceptedResponse.UnknownError(e)
                    }
                    parsedError
                }

                callback.onResponse(this@ElInterceptedResponseCall, Response.success(result))
            }

            override fun onFailure(call: Call<S>, t: Throwable) {
                val error = when (t) {
                    is IOException -> ElInterceptedResponse.NetworkError(t)
                    else -> ElInterceptedResponse.UnknownError(t)
                }
                callback.onResponse(this@ElInterceptedResponseCall, Response.success(error))
            }
        })
    }

    override fun timeout(): Timeout = delegate.timeout()
    override fun clone() = ElInterceptedResponseCall(delegate.clone(), converter)
    override fun isExecuted() = delegate.isExecuted
    override fun isCanceled() = delegate.isCanceled
    override fun cancel() = delegate.cancel()
    override fun request(): Request = delegate.request()
    override fun execute(): Response<ElInterceptedResponse<S>> {
        throw UnsupportedOperationException("Use suspend functions instead.")
    }
}
