package com.example.youtube.base.ui.detail.playlist

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.youtube.R
import com.example.youtube.base.BaseFragment
import com.example.youtube.base.ui.detail.playlist.Adapter.PlaylistAdapter
import com.example.youtube.databinding.FragmentPlayListBinding


class PlayListFragment : BaseFragment<FragmentPlayListBinding, PlayListViewModel>() {

    private  val adapter: PlaylistAdapter by lazy {
        PlaylistAdapter(this::onClick)
    }

    override val viewModel: PlayListViewModel by lazy {
        ViewModelProvider(this) [PlayListViewModel::class.java]
    }

    override fun inflateViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPlayListBinding {
        return  FragmentPlayListBinding.inflate(inflater, container, false)
    }

    override fun initView() {

    }

    override fun initViewModel() {
        super.initViewModel()
        viewModel.getPlayList().observe(viewLifecycleOwner){
            Log.e("ololo", "initViewModel: $it")
            adapter.addData(it.items)
        }
        binding.recyclerPlayList.adapter= adapter
    }

    private fun onClick(id:String){
        findNavController().navigate(R.id.detailFragment, bundleOf("id" to id))
    }



}