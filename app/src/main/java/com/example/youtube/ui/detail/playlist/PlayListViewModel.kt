package com.example.youtube.ui.detail.playlist


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtube.base.BaseViewModel
import com.example.youtube.data.remote.ApiService
import com.example.youtube.data.remote.Repository
import com.example.youtube.data.remote.RetrofitClient
import com.example.youtube.model.Playlist
import com.example.youtube.network.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayListViewModel : BaseViewModel() {
    private val repo =Repository()

    val getPlaylist:LiveData<Resource<Playlist>> = repo.getPlayList()


}