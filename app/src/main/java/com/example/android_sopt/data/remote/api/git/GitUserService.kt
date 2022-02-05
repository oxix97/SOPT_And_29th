package com.example.android_sopt.data.remote.api.git

import com.example.android_sopt.data.remote.model.git.ResponseFollowerListData
import com.example.android_sopt.data.remote.model.git.ResponseGetUserData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitUserService {
    @GET("users/oxix97/followers")
    fun getFollowerList(): Call<ResponseFollowerListData>

    @GET("users/{username}")
    fun getUserInformation(
        @Path("username")
        username: String
    ): Call<ResponseGetUserData>
}