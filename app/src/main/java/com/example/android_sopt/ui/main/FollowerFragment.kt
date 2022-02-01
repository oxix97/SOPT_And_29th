package com.example.android_sopt.ui.main

import android.os.Bundle
import android.view.View
import com.example.android_sopt.R
import com.example.android_sopt.base.baseutil.BaseViewUtil
import com.example.android_sopt.data.main.FollowerData

class FollowerFragment :
    BaseViewUtil.BaseFragment<com.example.android_sopt.databinding.FragmentFollowerBinding>(R.layout.fragment_follower) {
    private lateinit var followerAdapter: FollowerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun initView() {
        setFollowerItem()
    }

    private fun setFollowerItem() {
        val followerList = listOf<FollowerData>(
            FollowerData(
                R.drawable.user1,
                "유저1",
                "유저1입니다 하하!!"
            ),
            FollowerData(
                R.drawable.user2,
                "유저2",
                "유저2입니다 하하!!"
            ),
            FollowerData(
                R.drawable.user3,
                "유저3",
                "유저3입니다 하하!!"
            ),
            FollowerData(
                R.drawable.user4,
                "유저4",
                "유저4입니다 하하!!"
            ),
            FollowerData(
                R.drawable.user1,
                "유저1",
                "유저1입니다 하하!!"
            ),
            FollowerData(
                R.drawable.user2,
                "유저2",
                "유저2입니다 하하!!"
            ),
            FollowerData(
                R.drawable.user3,
                "유저3",
                "유저3입니다 하하!!"
            ),
            FollowerData(
                R.drawable.user4,
                "유저4",
                "유저4입니다 하하!!"
            )
        )
        followerAdapter = FollowerAdapter()
        binding.rvFollowerContainer.adapter = followerAdapter
        followerAdapter.followerList.addAll(followerList)
        followerAdapter.notifyDataSetChanged()
    }
}