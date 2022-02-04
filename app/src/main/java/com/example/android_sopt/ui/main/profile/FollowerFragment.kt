package com.example.android_sopt.ui.main.profile

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.android_sopt.R
import com.example.android_sopt.base.baseutil.BaseViewUtil
import com.example.android_sopt.data.remote.api.git.GitService
import com.example.android_sopt.data.remote.model.git.ResponseFollowerListData
import com.example.android_sopt.data.remote.model.git.ResponseGetUserData
import com.example.android_sopt.data.remote.model.git.UserData
import com.example.android_sopt.util.AdapterDecoration
import com.example.android_sopt.util.ItemTouchHelperCallback
import com.example.android_sopt.util.shortToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowerFragment :
    BaseViewUtil.BaseFragment<com.example.android_sopt.databinding.FragmentFollowerBinding>(R.layout.fragment_follower) {
    private lateinit var followerAdapter: FollowerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun initView() {
        initNetwork()
    }

    private fun initNetwork() {
        val call: Call<ResponseFollowerListData> = GitService.gitUserService.getFollowerList()

        call.enqueue(object : Callback<ResponseFollowerListData> {
            override fun onResponse(
                call: Call<ResponseFollowerListData>,
                response: Response<ResponseFollowerListData>
            ) {
                if (response.isSuccessful) {
                    val userList = response.body()
                    setUserData(userList)
                } else {
                    requireActivity().shortToast("팔로워 리스트 업로드 실패")
                }
            }

            override fun onFailure(call: Call<ResponseFollowerListData>, t: Throwable) {
                Log.e("error", "$t")
            }

        })
    }

    private fun setUserData(userList: ResponseFollowerListData?) {
        val userDataList = mutableListOf<UserData>()
        for (item in userList!!) {
            val call: Call<ResponseGetUserData> =
                GitService.gitUserService.getUserInformation(item.login)
            call.enqueue(object : Callback<ResponseGetUserData> {
                override fun onResponse(
                    call: Call<ResponseGetUserData>,
                    response: Response<ResponseGetUserData>
                ) {
                    if (response.isSuccessful) {
                        val data = response.body()
                        val temp = UserData(
                            data?.login.toString(),
                            data?.bio.toString(),
                            data?.avatarUrl.toString(),
                        )
                        userDataList.add(temp)
                    } else {
                        requireActivity().shortToast("불러오기 실패")
                    }
                }

                override fun onFailure(call: Call<ResponseGetUserData>, t: Throwable) {
                    Log.e("error", "$t")
                }
            })
        }
        setFollowerItem(userDataList)
    }

    private fun setFollowerItem(userDataList: MutableList<UserData>) {
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

        followerAdapter.followerList.addAll(userDataList)

        val itemTouchHelperCallback = ItemTouchHelperCallback(followerAdapter)
        val helper = ItemTouchHelper(itemTouchHelperCallback)
        helper.attachToRecyclerView(binding.rvFollowerContainer)
//        followerAdapter.notifyDataSetChanged()
    }
}