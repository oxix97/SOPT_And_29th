package com.example.android_sopt.data.remote.model.login


data class ResponseLoginData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data,
) {
    data class Data(
        val email: String,
        val id: Int,
        val name: String
    )
}