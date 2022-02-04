package com.example.android_sopt.data.remote.model.user


import com.google.gson.annotations.SerializedName

data class ResponseUserData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val `data`: Data,
) {
    data class Data(
        @SerializedName("email")
        val id: Int,
        val email: String,
        val name: String
    )
}