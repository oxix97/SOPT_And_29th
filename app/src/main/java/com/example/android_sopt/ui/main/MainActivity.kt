package com.example.android_sopt.ui.main

import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.android_sopt.R
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
        initFragment()
    }

    private fun initFragment() {
        val followerFragment = FollowerFragment()
        val repositoryFragment = RepositoryFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fr_container, followerFragment).commit()

        binding.btnMainFollower.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fr_container, followerFragment)
            transaction.commit()
        }
        binding.btnMainRepository.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fr_container, repositoryFragment)
            transaction.commit()
        }
    }
}