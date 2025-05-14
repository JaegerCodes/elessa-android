package com.llamasoft.elessa.data.network

import com.llamasoft.elessa.network.interceptor.response.ElInterceptedResponse
import okhttp3.ResponseBody
import retrofit2.http.GET

interface ViewComponentsService {

    @GET("1369783719707205632")
    suspend fun getViewComponents(): ElInterceptedResponse<ResponseBody>

}
