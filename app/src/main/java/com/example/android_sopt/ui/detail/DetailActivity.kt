package com.example.android_sopt.ui.detail

import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.android_sopt.R
import com.example.android_sopt.base.baseutil.BaseViewUtil
import com.example.android_sopt.databinding.ActivityDetailBinding

class DetailActivity :
    BaseViewUtil.BaseAppCompatActivity<ActivityDetailBinding>(R.layout.activity_detail) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        getIntentExtra()
    }

    private fun getIntentExtra() {
        val img = intent.getIntExtra("img", 99)
        val name = intent.getStringExtra("name")
        with(binding) {
            Glide
                .with(this@DetailActivity)
                .load(img)
                .override(64, 64)
                .into(ivDetailProfile)
            tvDetailName.text = name.toString()
        }
    }
}