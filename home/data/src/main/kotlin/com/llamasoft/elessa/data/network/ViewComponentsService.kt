package com.llamasoft.elessa.data.network

import com.llamasoft.elessa.network.interceptor.response.ElInterceptedResponse
import okhttp3.ResponseBody
import retrofit2.http.GET

interface ViewComponentsService {

    @GET("1369783719707205632")
    suspend fun getHomeContainer(): ElInterceptedResponse<ResponseBody>

    @GET("1369783669883068416")
    suspend fun getHomeComponents(): ElInterceptedResponse<ResponseBody>
}
