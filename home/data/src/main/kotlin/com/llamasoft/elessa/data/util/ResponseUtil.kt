package com.llamasoft.elessa.data.util

import android.accounts.NetworkErrorException
import com.llamasoft.elessa.network.interceptor.response.ApiErrorException
import com.llamasoft.elessa.network.interceptor.response.ElInterceptedResponse
import com.llamasoft.elessa.network.interceptor.response.JsonParseException
import com.llamasoft.elessa.network.interceptor.response.UnknownErrorException
import com.squareup.moshi.Moshi

inline fun <T, R> ElInterceptedResponse<T>.mapSuccessOrError(transform: (T) -> R): Result<R> {
    return try {
        when (this) {
            is ElInterceptedResponse.Success -> {
                body?.let { Result.success(transform(it)) }
                    ?: Result.failure(NullPointerException("Response body is null"))
            }
            is ElInterceptedResponse.ApiError -> {
                Result.failure(ApiErrorException("API error $code"))
            }
            is ElInterceptedResponse.NetworkError -> {
                Result.failure(NetworkErrorException("Network error: ${error.message}"))
            }
            is ElInterceptedResponse.UnknownError -> {
                Result.failure(UnknownErrorException("Unknown error: ${error.message}"))
            }
        }
    } catch (e: Exception) {
        Result.failure(e)
    }
}

inline fun <reified T> Moshi.fromJsonOrError(json: String): Result<T> {
    return try {
        adapter(T::class.java).fromJson(json)?.let { Result.success(it) }
            ?: Result.failure(JsonParseException("Failed to parse JSON to ${T::class.java.simpleName}. JSON: $json"))
    } catch (e: Exception) {
        Result.failure(JsonParseException("Failed to parse JSON: ${e.message}. JSON: $json"))
    }
}
