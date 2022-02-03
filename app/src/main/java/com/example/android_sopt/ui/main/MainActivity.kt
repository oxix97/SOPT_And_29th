package com.example.android_sopt.ui.main

import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.android_sopt.R
import com.example.android_sopt.base.baseutil.BaseViewUtil
import com.example.android_sopt.databinding.ActivityMainBinding

class MainActivity :
    BaseViewUtil.BaseAppCompatActivity<ActivityMainBinding>(R.layout.activity_main) {
    private lateinit var mainViewAdapter: MainViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        initAdapter()
        initBottomNavi()
    }

    private fun initAdapter() {
        val fragmentList = listOf(ProfileFragment(), HomeFragment(), CameraFragment())
        mainViewAdapter = MainViewAdapter(this)
        mainViewAdapter.fragments.addAll(fragmentList)
        binding.vpMainContainer.adapter = mainViewAdapter
    }

    private fun initBottomNavi() {
        with(binding) {
            vpMainContainer.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.bnavMain.menu.getItem(position).isChecked = true
                }
            })

            bnavMain.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_profile -> {
                        vpMainContainer.currentItem = PROFILE_FRAGMENT
                        return@setOnItemSelectedListener true
                    }
                    R.id.menu_home -> {
                        vpMainContainer.currentItem = HOME_FRAGMENT
                        return@setOnItemSelectedListener true
                    }
                    else -> {
                        vpMainContainer.currentItem = CAMERA_FRAGMENT
                        return@setOnItemSelectedListener true
                    }
                }
            }
        }
    }

    companion object {
        const val PROFILE_FRAGMENT = 0
        const val HOME_FRAGMENT = 1
        const val CAMERA_FRAGMENT = 2
    }
}