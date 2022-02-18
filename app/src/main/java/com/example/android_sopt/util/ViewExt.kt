package com.example.android_sopt.util

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.roundToInt

fun Context.shortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

// dp To px
fun View.px(dp: Int) = (dp * resources.displayMetrics.density).roundToInt()

fun <ResponseType> Call<ResponseType>.enqueueUtil(
    onSuccess: (ResponseType) -> Unit,
    onError: (ResponseBody?) -> Unit = {}
) {
    this.enqueue(object : Callback<ResponseType> {
        override fun onResponse(call: Call<ResponseType>, response: Response<ResponseType>) {
            if (response.isSuccessful) {
                response.body()?.let {
                    onSuccess(it)
                } ?: onError(response.errorBody())
            }
        }

        override fun onFailure(call: Call<ResponseType>, t: Throwable) {
            Log.e("error", "$t")
        }
    })
}