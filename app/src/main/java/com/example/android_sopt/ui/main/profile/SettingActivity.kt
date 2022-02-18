package com.example.android_sopt.ui.main.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_sopt.R
import com.example.android_sopt.base.baseutil.BaseViewUtil
import com.example.android_sopt.databinding.ActivitySettingBinding
import com.example.android_sopt.ui.sign.SignInActivity
import com.example.android_sopt.util.SOPTSharedPreferences
import kotlin.math.sign

class SettingActivity :
    BaseViewUtil.BaseAppCompatActivity<ActivitySettingBinding>(R.layout.activity_setting) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        signout()
    }

    private fun signout() {
        binding.llSettingLogout.setOnClickListener {
            SOPTSharedPreferences.removeAutoLogin(this)
            startActivity(Intent(this, SignInActivity::class.java))
            finish()
        }
    }
}