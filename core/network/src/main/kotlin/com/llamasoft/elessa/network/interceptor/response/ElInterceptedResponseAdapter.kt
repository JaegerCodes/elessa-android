package com.llamasoft.elessa.network.interceptor.response

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Converter
import java.lang.reflect.Type

class ElInterceptedResponseAdapter<S : Any>(
    private val successType: Type,
    private val converter: Converter<ResponseBody, S>
) : CallAdapter<S, Call<ElInterceptedResponse<S>>> {

    override fun responseType(): Type = successType

    override fun adapt(call: Call<S>): Call<ElInterceptedResponse<S>> {
        return ElInterceptedResponseCall(call, converter)
    }
}
