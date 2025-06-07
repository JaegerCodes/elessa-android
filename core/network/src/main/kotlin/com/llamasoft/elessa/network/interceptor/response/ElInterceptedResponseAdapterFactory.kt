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
        var result: CallAdapter<*, *>? = null

        if (Call::class.java == getRawType(returnType) &&
            returnType is ParameterizedType
        ) {
            val responseType = getParameterUpperBound(0, returnType)
            if (getRawType(responseType) == ElInterceptedResponse::class.java &&
                responseType is ParameterizedType
            ) {
                val successType = getParameterUpperBound(0, responseType)
                val converter: Converter<ResponseBody, Any> =
                    retrofit.responseBodyConverter(successType, annotations)
                result = ElInterceptedResponseAdapter(successType, converter)
            }
        }
        return result
    }
}

