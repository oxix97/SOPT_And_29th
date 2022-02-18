package com.example.android_sopt.ui.main.onboding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android_sopt.R
import com.example.android_sopt.base.baseutil.BaseViewUtil
import com.example.android_sopt.databinding.FragmentOnBoding2Binding


class OnBodingFragment2 :
    BaseViewUtil.BaseFragment<FragmentOnBoding2Binding>(R.layout.fragment_on_boding2) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun initView() {
        nextButton()
    }

    private fun nextButton() {
        binding.btnOnboding2Next.setOnClickListener {
            findNavController().navigate(R.id.navComp2_to_navComp3)
        }
    }


}