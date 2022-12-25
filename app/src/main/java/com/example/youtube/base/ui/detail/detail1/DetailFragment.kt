package com.example.youtube.base.ui.detail.detail1

import android.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.youtube.base.BaseFragment
import com.example.youtube.base.ui.detail.playlist.PlayListFragment
import com.example.youtube.base.ui.detail.playlist.PlayListViewModel
import com.example.youtube.databinding.FragmentDetailBinding

class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>() {

    override val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this)[DetailViewModel::class.java]
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater, container, false)

    }


    override fun initView() {
        val id = arguments?.getString("id ")
        viewModel.getPlayListItems(id.toString()).observe(viewLifecycleOwner) {
            Log.e("ololo", "initView:$it")
        }
    }


}