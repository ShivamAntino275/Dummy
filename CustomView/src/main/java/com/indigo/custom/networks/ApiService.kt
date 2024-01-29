package com.indigo.custom.networks

import com.indigo.custom.ApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun callServer(): Response<ApiResponse>
}