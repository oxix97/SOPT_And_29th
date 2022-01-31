package com.example.android_sopt

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.example.android_sopt.base.baseutil.BaseViewUtil
import com.example.android_sopt.databinding.ActivityMainBinding

class MainActivity :
    BaseViewUtil.BaseAppCompatActivity<ActivityMainBinding>(R.layout.activity_main) {
    var name = "이종찬"
    var age = "26"
    var mbti = "ISTJ"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.mainViewModel = this
        initView()
    }

    override fun initView() {
        githubLink()
    }

    private fun githubLink() {
        binding.ivMainGithubLink.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/oxix97"))
            startActivity(intent)
        }
    }
}