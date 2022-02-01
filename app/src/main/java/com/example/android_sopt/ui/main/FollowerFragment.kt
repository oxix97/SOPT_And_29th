package com.example.android_sopt.ui.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.android_sopt.R
import com.example.android_sopt.base.baseutil.BaseViewUtil
import com.example.android_sopt.data.main.FollowerData
import com.example.android_sopt.util.AdapterDecoration
import com.example.android_sopt.util.ItemTouchHelperCallback

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
        binding.rvFollowerContainer.addItemDecoration(
            AdapterDecoration(
                requireActivity(),
                R.drawable.line_divider,
                0,
                0,
                10,
            )
        )

        followerAdapter.followerList.addAll(followerList)

        val itemTouchHelperCallback = ItemTouchHelperCallback(followerAdapter)
        val helper = ItemTouchHelper(itemTouchHelperCallback)
        helper.attachToRecyclerView(binding.rvFollowerContainer)
        followerAdapter.notifyDataSetChanged()
    }
}