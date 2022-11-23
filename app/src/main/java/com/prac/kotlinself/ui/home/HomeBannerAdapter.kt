package com.prac.kotlinself.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.prac.kotlinself.databinding.SlideBannerBinding
import com.prac.kotlinself.model.Banner

class BannerAdapter : ListAdapter<Banner, BannerAdapter.BannerViewHolder>(
    BannerAdapterDiffCallBack()
){
    private lateinit var binding : SlideBannerBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        binding=SlideBannerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BannerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class BannerViewHolder(private val binding : SlideBannerBinding ) : RecyclerView.ViewHolder(binding.root){
        fun bind(banner : Banner){
            binding.banner = banner
            binding.executePendingBindings()
        }
    }

}

class BannerAdapterDiffCallBack : DiffUtil.ItemCallback<Banner>(){
    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem.bannerId == newItem.bannerId
    }

    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem == newItem
    }

}