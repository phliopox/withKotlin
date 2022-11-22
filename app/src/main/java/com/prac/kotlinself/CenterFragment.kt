package com.prac.kotlinself

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.prac.kotlinself.databinding.FragmentCenterBinding


class CenterFragment : Fragment() {

    private val viewModel :HomeViewModel by viewModels{ ViewModelFactory(requireContext())}
    private lateinit var binding :FragmentCenterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCenterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner

        with(binding.viewpagerHomeBanner){
        val adapter = BannerAdapter().apply {
            viewModel.banners.observe(viewLifecycleOwner) { banners ->
                submitList(banners)
                }
            }
            val screenWidth = resources.displayMetrics.widthPixels
            val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
            val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)
            //페이지당 크기 312dp , 페이지당 간격 16dp -> 픽셀로 단위 변경
            val offset = screenWidth - pageWidth - pageMargin
            setPageTransformer{ page, position ->
                page.translationX = position * -offset
            }
            offscreenPageLimit = 3

        }
    }
}