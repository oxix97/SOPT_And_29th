package com.example.android_sopt.ui.sign

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.example.android_sopt.ui.main.MainActivity
import com.example.android_sopt.R
import com.example.android_sopt.base.baseutil.BaseViewUtil
import com.example.android_sopt.databinding.ActivitySignInBinding
import com.example.android_sopt.util.shortToast

class SignInActivity :
    BaseViewUtil.BaseAppCompatActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {
    private lateinit var registerLauncher: ActivityResultLauncher<Intent>
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
            .override(64,64)
            .into(binding.ivSigninTitle)
    }

    private fun login() {
        binding.btnSigninLogin.setOnClickListener {
            if (!idChecker() && !pwChecker()) {
                val intent = Intent(this@SignInActivity, MainActivity::class.java)
                shortToast("환영합니다")
                startActivity(intent)
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

    private fun pwChecker(): Boolean = binding.etSigninPassword.text.isNullOrBlank()

    private fun idChecker(): Boolean = binding.etSigninId.text.isNullOrBlank()

}