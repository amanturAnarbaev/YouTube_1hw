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

class DetailFragment:BaseFragment<FragmentDetailBinding,PlayListViewModel>() {
    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailBinding {
        return FragmentDetailBinding.inflate(inflater,container,false)

    }




    override fun initListener() {
        super.initListener()
    }
    override fun initView() {
    }

    override fun initViewModel() {
        super.initViewModel()
        Log.e("ololo", "kflmweone")
    }

    override val viewModel: PlayListViewModel by lazy {
        ViewModelProvider(this)[PlayListViewModel::class.java]
    }
}