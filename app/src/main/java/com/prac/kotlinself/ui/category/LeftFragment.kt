package com.prac.kotlinself.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.prac.kotlinself.R
import com.prac.kotlinself.ViewModelFactory
import com.prac.kotlinself.databinding.FragementLeftBinding
import com.prac.kotlinself.databinding.FragmentCenterBinding

class LeftFragment :Fragment() {

    private val viewModel : CategoryViewModel by viewModels{ViewModelFactory(requireContext())}
     private lateinit var binding : FragementLeftBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding = FragementLeftBinding.inflate(inflater, container, false)
        return binding.root
        //return inflater.inflate(R.layout.fragement_left, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryAdapter = CategoryAdapter(viewModel)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.categoryList.adapter = categoryAdapter
        viewModel.category.observe(viewLifecycleOwner){
            categoryAdapter.submitList(it)

        }

    }


}