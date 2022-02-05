package com.example.android_sopt.ui.main.home

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.android_sopt.R
import com.example.android_sopt.base.baseutil.BaseViewUtil
import com.example.android_sopt.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : BaseViewUtil.BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private lateinit var homeViewAdapter: HomeViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun initView() {
        setImage()
        initAdapter()
        initTabLayout()
    }

    private fun setImage() {
        Glide
            .with(requireActivity())
            .load(R.drawable.img_github)
            .override(64, 64)
            .into(binding.ivHomeGithub)
    }

    private fun initAdapter() {
        val fragmentList = listOf(HomeFollowerFragment(), HomeFollowingFragment())

        homeViewAdapter = HomeViewAdapter(this)
        homeViewAdapter.fragments.addAll(fragmentList)

        binding.vpHomeContainer.adapter = homeViewAdapter
    }

    private fun initTabLayout() {
        val tabLabel = listOf("팔로잉", "팔로워")

        with(binding) {
            TabLayoutMediator(tlHomeFollow, vpHomeContainer) { tab, position ->
                tab.text = tabLabel[position]
            }.attach()
        }
    }
}