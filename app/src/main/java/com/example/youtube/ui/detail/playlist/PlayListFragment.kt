package com.example.youtube.ui.detail.playlist

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.youtube.App
import com.example.youtube.R
import com.example.youtube.base.BaseFragment
import com.example.youtube.ui.detail.playlist.Adapter.PlaylistAdapter
import com.example.youtube.databinding.FragmentPlayListBinding
import com.example.youtube.network.Status
import com.example.youtube.utils.isOnline


class PlayListFragment : BaseFragment<FragmentPlayListBinding, PlayListViewModel>() {

    private val adapter: PlaylistAdapter by lazy {
        PlaylistAdapter(this::onClick)
    }

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

    }





    @RequiresApi(Build.VERSION_CODES.M)
    override fun initListener() {
        super.initListener()
        binding.noInternetInclude.tryAgain.setOnClickListener {
            checkInternet()
        }
    }

    override fun initViewModel() {
        super.initViewModel()

        viewModel.getPlaylist.observe(viewLifecycleOwner){
            if(it.status==Status.SUCCESS){
                adapter.addData(it.data?.items)
            }

            else{
                Log.e("ololo", "initViewModel"+it.msg)
            }
            binding.recyclerPlayList.adapter=adapter

        }
    }

    private fun onClick(id: String) {
        findNavController().navigate(R.id.detailFragment, bundleOf("id" to id))
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun checkInternet() {
        val onLine = isOnline(requireContext())
        binding.recyclerPlayList.isVisible = onLine
        binding.noInternetContainer.isVisible = !onLine

    }
}


