package com.llamasoft.elessa.network.interceptor.response

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class ElInterceptedResponseAdapterFactory : CallAdapter.Factory() {
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        if (Call::class.java != getRawType(returnType)) return null
        if (returnType !is ParameterizedType) return null

        val responseType = getParameterUpperBound(0, returnType)
        if (getRawType(responseType) != ElInterceptedResponse::class.java) return null
        if (responseType !is ParameterizedType) return null

        val successType = getParameterUpperBound(0, responseType)

        val converter: Converter<ResponseBody, Any> =
            retrofit.responseBodyConverter(successType, annotations)

        return ElInterceptedResponseAdapter(successType, converter)
    }
}
