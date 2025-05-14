package com.llamasoft.elessa.data.util

import com.llamasoft.elessa.network.interceptor.response.ElInterceptedResponse
import com.squareup.moshi.Moshi

inline fun <T, R> ElInterceptedResponse<T>.mapSuccessOrError(transform: (T) -> R): R {
    return when (this) {
        is ElInterceptedResponse.Success -> {
            body?.let(transform) ?: error("Response body is null")
        }
        is ElInterceptedResponse.ApiError -> error("API error $code")
        is ElInterceptedResponse.NetworkError -> error("NetworkError error")
        is ElInterceptedResponse.UnknownError -> error("UnknownError error")
    }
}

inline fun <reified T> Moshi.fromJsonOrThrow(json: String): T {
    return adapter(T::class.java).fromJson(json)
        ?: error("Failed to parse JSON to ${T::class.java.simpleName}")
}
