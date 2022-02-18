package com.example.android_sopt.ui.main.onboding

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.android_sopt.R
import com.example.android_sopt.base.baseutil.BaseViewUtil
import com.example.android_sopt.databinding.ActivityOnBodingBinding

class OnBodingActivity :
    BaseViewUtil.BaseAppCompatActivity<ActivityOnBodingBinding>(R.layout.activity_on_boding) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        initToolBar()
    }

    private fun initToolBar() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_container) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.tbOnbodingTitle.setupWithNavController(navController, appBarConfiguration)
    }
}