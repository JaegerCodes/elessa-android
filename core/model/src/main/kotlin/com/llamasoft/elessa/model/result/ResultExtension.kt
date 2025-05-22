package com.llamasoft.elessa.model.result

inline fun <T> Result<T>.onResult(
    onSuccess: (T) -> Unit,
    onFailure: (Throwable) -> Unit
) {
    if (isSuccess) {
        getOrNull()?.let { onSuccess(it) }
    } else {
        exceptionOrNull()?.let { onFailure(it) }
    }
}
