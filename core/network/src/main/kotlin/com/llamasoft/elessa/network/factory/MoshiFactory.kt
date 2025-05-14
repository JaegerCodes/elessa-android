package com.llamasoft.elessa.network.factory

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MoshiFactory(
    private val baseAdapters: List<JsonAdapter.Factory> = emptyList()
) {
    fun create(extraAdapters: List<JsonAdapter.Factory> = emptyList()): Moshi {
        return Moshi.Builder()
            .apply {
                baseAdapters.forEach { add(it) }
                extraAdapters.forEach { add(it) }
                add(KotlinJsonAdapterFactory())
            }
            .build()
    }
}
