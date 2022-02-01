package com.example.android_sopt.ui.sign

import android.content.Intent
import android.os.Bundle
import com.example.android_sopt.R
import com.example.android_sopt.base.baseutil.BaseViewUtil
import com.example.android_sopt.databinding.ActivitySignUpBinding
import com.example.android_sopt.util.shortToast

class SignUpActivity :
    BaseViewUtil.BaseAppCompatActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        login()
    }

    private fun login() {
        with(binding) {
            btnSignupSignup.setOnClickListener {
                if (!idChecker() && !pwChecker() && !nameChecker()) {
                    val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
                    intent.putExtra("id", etSignupId.text.toString())
                    intent.putExtra("password", etSignupPassword.text.toString())
                    setResult(RESULT_OK, intent)
                    finish()
                } else {
                    shortToast("로그인 실패")
                }
            }
        }

    }

    private fun pwChecker(): Boolean = binding.etSignupPassword.text.isNullOrBlank()
    private fun idChecker(): Boolean = binding.etSignupId.text.isNullOrBlank()
    private fun nameChecker(): Boolean = binding.etSignupName.text.isNullOrBlank()

}