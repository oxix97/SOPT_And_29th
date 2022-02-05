package com.example.android_sopt.data.remote.model.login

import com.google.gson.annotations.SerializedName

data class RequestLoginData(
    @SerializedName("email")
    val id: String,
    val password: String,
)
