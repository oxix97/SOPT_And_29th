package com.example.android_sopt.ui.main.home

import android.os.Bundle
import android.view.View
import com.example.android_sopt.R
import com.example.android_sopt.base.baseutil.BaseViewUtil
import com.example.android_sopt.databinding.FragmentHomeFollowingBinding

class HomeFollowingFragment :
    BaseViewUtil.BaseFragment<FragmentHomeFollowingBinding>(R.layout.fragment_home_following) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun initView() {

    }
}