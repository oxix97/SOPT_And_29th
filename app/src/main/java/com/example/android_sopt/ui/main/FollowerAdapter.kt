package com.example.android_sopt.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_sopt.R
import com.example.android_sopt.data.main.FollowerData
import com.example.android_sopt.databinding.ItemFollowerBinding
import com.example.android_sopt.ui.detail.DetailActivity
import com.example.android_sopt.util.ItemTouchHelperListener

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>(),
    ItemTouchHelperListener {
    val followerList = mutableListOf<FollowerData>()

    inner class FollowerViewHolder(private val binding: ItemFollowerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: FollowerData) {
            with(binding) {
                Glide
                    .with(itemView.context)
                    .load(data.img)
                    .override(48, 48)
                    .into(ivFollowerProfile)
                tvFollowerName.text = data.name
                tvFollowerTitle.text = data.title

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra("img", data.img)
                    intent.putExtra("name", data.name)
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