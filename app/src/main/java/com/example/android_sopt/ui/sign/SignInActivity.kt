package com.example.android_sopt.ui.sign

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.android_sopt.ui.main.MainActivity
import com.example.android_sopt.R
import com.example.android_sopt.base.baseutil.BaseViewUtil
import com.example.android_sopt.data.remote.api.login.ApiService
import com.example.android_sopt.data.remote.model.login.RequestLoginData
import com.example.android_sopt.data.remote.model.login.ResponseLoginData
import com.example.android_sopt.databinding.ActivitySignInBinding
import com.example.android_sopt.util.shortToast
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class SignInActivity :
    BaseViewUtil.BaseAppCompatActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {
    private lateinit var registerLauncher: ActivityResultLauncher<Intent>
    private lateinit var list: ResponseLoginData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        setImage()
        login()
        signup()
        setResultSignUp()
    }

    private fun setImage() {
        Glide
            .with(this)
            .load(R.drawable.img_github)
            .override(64, 64)
            .into(binding.ivSigninTitle)
    }

    private fun login() {
        binding.btnSigninLogin.setOnClickListener {
            if (!idChecker() && !pwChecker()) {
                initNetwork()
            } else {
                shortToast("로그인 실패")
            }
        }
    }

    private fun signup() {
        binding.tvSigninSignup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            registerLauncher.launch(intent)
        }
    }

    private fun setResultSignUp() {
        registerLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == Activity.RESULT_OK) {
                    val id = it.data?.getStringExtra("id")
                    val password = it.data?.getStringExtra("password")
                    binding.etSigninId.setText(id)
                    binding.etSigninPassword.setText(password)
                }
            }

    }

    private fun initNetwork() {
        val requestLoginData = RequestLoginData(
            id = binding.etSigninId.text.toString(),
            password = binding.etSigninPassword.text.toString(),
        )

        lifecycleScope.launch {
            try {
                list = ApiService.loginService.postLogin(requestLoginData)
                if (list.success) {
                    shortToast("로그인 성공")
                    startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                } else {
                    shortToast("로그인 실패")
                }

            } catch (e: Exception) {
                Log.e("실패", "$e")
            }

        }
    }

    private fun pwChecker(): Boolean = binding.etSigninPassword.text.isNullOrBlank()

    private fun idChecker(): Boolean = binding.etSigninId.text.isNullOrBlank()

}