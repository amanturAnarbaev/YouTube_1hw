package com.example.youtube.base.ui.detail.playlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.youtube.BuildConfig.BASE_URL
import com.example.youtube.base.BaseFragment
import com.example.youtube.databinding.FragmentPlayListBinding


class PlayListFragment : BaseFragment<FragmentPlayListBinding, PlayListViewModel>() {

    override val viewModel: PlayListViewModel by lazy {
        ViewModelProvider(this)[PlayListViewModel::class.java]
    }


    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlayListBinding {
        return FragmentPlayListBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.getPlayList().observe(viewLifecycleOwner) {
            Log.e("ololo", "initViewModel " + it)
        }
    }


}