package com.example.youtube.ui.detail

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.youtube.base.BaseFragment
import com.example.youtube.databinding.FragmentDetailBinding
import com.example.youtube.network.Status

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
        val id = arguments?.getString("id")
        viewModel.getPlaylistItem(id.toString()).observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    viewModel.loading.value = false
                    Log.e("ololo","initView"+it.data)
                }
                Status.LOADING -> {
                    viewModel.loading.value = true
                }
                Status.ERROR -> {
                    viewModel.loading.value = false
                }

            }
            viewModel.loading.observe(viewLifecycleOwner) {
                binding.progresBar.isVisible = it
            }

        }
    }


}