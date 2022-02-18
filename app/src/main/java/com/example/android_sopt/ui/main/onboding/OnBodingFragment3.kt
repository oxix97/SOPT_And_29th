package com.example.android_sopt.ui.main.onboding

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.android_sopt.R
import com.example.android_sopt.base.baseutil.BaseViewUtil
import com.example.android_sopt.databinding.FragmentOnBoding3Binding
import com.example.android_sopt.ui.sign.SignInActivity

class OnBodingFragment3 :
    BaseViewUtil.BaseFragment<FragmentOnBoding3Binding>(R.layout.fragment_on_boding3) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun initView() {
        binding.btnOnboding3Finish.setOnClickListener {
            startActivity(Intent(requireActivity(), SignInActivity::class.java))
            requireActivity().finish()
        }
    }
}