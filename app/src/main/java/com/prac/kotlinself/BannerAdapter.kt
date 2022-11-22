package com.prac.kotlinself

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.prac.kotlinself.databinding.SlideBannerBinding

class BannerAdapter : ListAdapter< HomeBannerModel , BannerAdapter.BannerViewHolder >(
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
        fun bind(banner : HomeBannerModel){
            binding.banner = banner
            binding.executePendingBindings()
        }
    }

}

class BannerAdapterDiffCallBack : DiffUtil.ItemCallback<HomeBannerModel>(){
    override fun areItemsTheSame(oldItem: HomeBannerModel, newItem: HomeBannerModel): Boolean {
        return oldItem.bannerId == newItem.bannerId
    }

    override fun areContentsTheSame(oldItem: HomeBannerModel, newItem: HomeBannerModel): Boolean {
        return oldItem == newItem
    }

}