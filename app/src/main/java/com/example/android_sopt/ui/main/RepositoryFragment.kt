package com.example.android_sopt.ui.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_sopt.R
import com.example.android_sopt.base.baseutil.BaseViewUtil
import com.example.android_sopt.data.main.RepositoryData
import com.example.android_sopt.databinding.FragmentRepositoryBinding

class RepositoryFragment :
    BaseViewUtil.BaseFragment<FragmentRepositoryBinding>(R.layout.fragment_repository) {
    private lateinit var repositoryAdapter: RepositoryAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun initView() {
        setRepositoryList()
    }

    private fun setRepositoryList() {
        val repositoryList = listOf(
            RepositoryData(
                "유저1",
                "유저 1입니다 포항항항!!!"
            ),
            RepositoryData(
                "유저2",
                "유저 2입니다 포항항항!!!"
            ),
            RepositoryData(
                "유저3",
                "유저 3입니다 포항항항!!!"
            ),
            RepositoryData(
                "유저4",
                "유저 4입니다 포항항항!!!"
            ),
            RepositoryData(
                "유저1",
                "유저 1입니다 포항항항!!!"
            ),
            RepositoryData(
                "유저2",
                "유저 2입니다 포항항항!!!"
            ),
            RepositoryData(
                "유저3",
                "유저 3입니다 포항항항!!!"
            ),
            RepositoryData(
                "유저4",
                "유저 4입니다 포항항항!!!"
            ),
            RepositoryData(
                "유저1",
                "유저 1입니다 포항항항!!!"
            ),
            RepositoryData(
                "유저2",
                "유저 2입니다 포항항항!!!"
            ),
            RepositoryData(
                "유저3",
                "유저 3입니다 포항항항!!!"
            ),

            )
        repositoryAdapter = RepositoryAdapter()
        binding.rvRepositoryContainer.adapter = repositoryAdapter
        binding.rvRepositoryContainer.layoutManager = GridLayoutManager(requireContext(), 2)
        repositoryAdapter.repositoryList.addAll(repositoryList)
        repositoryAdapter.notifyDataSetChanged()
    }
}