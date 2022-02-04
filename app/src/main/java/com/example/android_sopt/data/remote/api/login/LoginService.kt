package com.example.android_sopt.data.remote.api.login


import com.example.android_sopt.data.remote.model.login.RequestLoginData
import com.example.android_sopt.data.remote.model.login.ResponseLoginData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService {

    @POST("user/login")
    fun postLogin(
        @Body body: RequestLoginData
    ): Call<ResponseLoginData>
}