package com.prac.kotlinself.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.prac.kotlinself.databinding.CategoryBinding
import com.prac.kotlinself.databinding.FragementLeftBinding
import com.prac.kotlinself.model.CategoryItem
import com.prac.kotlinself.repository.CategoryDataSource

class CategoryAdapter(private val viewModel: CategoryViewModel) :ListAdapter<CategoryItem,CategoryAdapter.CategoryViewHolder>(CategoryDiffCallBack()) {

    //private lateinit var binding: CategoryBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
      val  binding = CategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CategoryViewHolder(private var binding: CategoryBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(category : CategoryItem){
           // binding.viewModel =viewModel
            binding.categoryItem = category
            binding.executePendingBindings()
        }
    }
}
class CategoryDiffCallBack : DiffUtil.ItemCallback<CategoryItem>(){
    override fun areItemsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
        return oldItem.alphabet == newItem.alphabet
    }

    override fun areContentsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
        return oldItem == newItem
    }

}