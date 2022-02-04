package com.example.android_sopt.ui.main.profile

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.android_sopt.R
import com.example.android_sopt.base.baseutil.BaseViewUtil
import com.example.android_sopt.databinding.FragmentProfileBinding

class ProfileFragment :
    BaseViewUtil.BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {
    var name = "Jongchan Lee"
    var id = "oxix_97"
    var title = "초보 개발자 이종찬 입니다 !!"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun initView() {
        initFragment()
        setProfile()
    }

    private fun setProfile() {
        with(binding) {
            profile = this@ProfileFragment
            btnProfileFollower.isSelected = true
            Glide
                .with(requireContext())
                .load(R.drawable.group_814)
                .override(64, 64)
                .into(ivProfileProfile)
        }

    }

    private fun initFragment() {
        val followerFragment = FollowerFragment()
        val repositoryFragment = RepositoryFragment()

        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.add(R.id.fr_profile_container, followerFragment).commit()

        with(binding) {
            btnProfileFollower.setOnClickListener {
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fr_profile_container, followerFragment)
                btnProfileFollower.isSelected = true
                btnProfileRepository.isSelected = false
                transaction.commit()
            }

            btnProfileRepository.setOnClickListener {
                val transaction = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(R.id.fr_profile_container, repositoryFragment)
                btnProfileFollower.isSelected = false
                btnProfileRepository.isSelected = true
                transaction.commit()
            }
        }
    }
}