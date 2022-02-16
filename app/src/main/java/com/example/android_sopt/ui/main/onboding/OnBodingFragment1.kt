package com.example.android_sopt.ui.main.onboding

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.android_sopt.R
import com.example.android_sopt.base.baseutil.BaseViewUtil
import com.example.android_sopt.databinding.FragmentOnBoding1Binding

class OnBodingFragment1 :
    BaseViewUtil.BaseFragment<FragmentOnBoding1Binding>(R.layout.fragment_on_boding1) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun initView() {
        nextButton()
    }

    private fun nextButton() {
        binding.btnOnboding1Next.setOnClickListener {
            findNavController().navigate(R.id.navComp1_to_navComp2)
        }
    }
}