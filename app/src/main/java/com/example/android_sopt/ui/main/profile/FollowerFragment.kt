package com.example.android_sopt.ui.main.profile

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.android_sopt.R
import com.example.android_sopt.base.baseutil.BaseViewUtil
import com.example.android_sopt.data.remote.api.git.GitService
import com.example.android_sopt.data.remote.api.login.ApiService
import com.example.android_sopt.data.remote.model.git.ResponseFollowerListData
import com.example.android_sopt.data.remote.model.git.ResponseGetUserData
import com.example.android_sopt.data.remote.model.git.UserData
import com.example.android_sopt.util.AdapterDecoration
import com.example.android_sopt.util.ItemTouchHelperCallback
import com.example.android_sopt.util.shortToast
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class FollowerFragment :
    BaseViewUtil.BaseFragment<com.example.android_sopt.databinding.FragmentFollowerBinding>(R.layout.fragment_follower) {
    private lateinit var followerAdapter: FollowerAdapter
    private lateinit var followerList: ResponseFollowerListData
    private lateinit var userData: ResponseGetUserData
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun initView() {
        initNetwork()
    }

    private fun initNetwork() {
        lifecycleScope.launch {
            try {
                followerList = GitService.gitUserService.getFollowerList()
                setFollowers(followerList)
            } catch (e: Exception) {
                Log.e("실패", "$e")
            }
        }
    }

    private fun setFollowers(followerList: ResponseFollowerListData) {
        followerAdapter = FollowerAdapter()
        with(binding) {
            rvFollowerContainer.adapter = followerAdapter
            rvFollowerContainer.addItemDecoration(
                AdapterDecoration(
                    requireActivity(),
                    R.drawable.line_divider,
                    0, 0, 10,
                )
            )
            val itemTouchHelperCallback = ItemTouchHelperCallback(followerAdapter)
            val helper = ItemTouchHelper(itemTouchHelperCallback)
            helper.attachToRecyclerView(binding.rvFollowerContainer)
        }
        followerAdapter.followerList.addAll(followerList)
    }
}