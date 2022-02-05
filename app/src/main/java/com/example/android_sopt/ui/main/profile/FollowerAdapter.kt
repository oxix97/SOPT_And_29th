package com.example.android_sopt.ui.main.profile

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_sopt.data.remote.api.git.GitService
import com.example.android_sopt.data.remote.model.git.ResponseFollowerListDataItem
import com.example.android_sopt.data.remote.model.git.ResponseGetUserData
import com.example.android_sopt.data.remote.model.git.UserData
import com.example.android_sopt.databinding.ItemFollowerBinding
import com.example.android_sopt.ui.detail.DetailActivity
import com.example.android_sopt.util.ItemTouchHelperListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>(),
    ItemTouchHelperListener {
    val followerList = mutableListOf<UserData>()

    inner class FollowerViewHolder(private val binding: ItemFollowerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: UserData) {
            with(binding) {
                Glide
                    .with(itemView)
                    .load(data.img)
                    .override(48, 48)
                    .into(ivFollowerProfile)
                tvFollowerName.text = data.login
                tvFollowerTitle.text = data.bio

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra("img", data.img)
                    intent.putExtra("name", data.login)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding =
            ItemFollowerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(followerList[position])
    }

    override fun getItemCount(): Int = followerList.size
    override fun onItemMove(from_position: Int, to_position: Int): Boolean {
        val item = followerList[from_position]
        followerList.removeAt(from_position)
        followerList.add(to_position, item)
        notifyItemMoved(from_position, to_position)
        return true
    }

    override fun onItemSwipe(position: Int) {
        followerList.removeAt(position)
        notifyItemRemoved(position)
    }
}