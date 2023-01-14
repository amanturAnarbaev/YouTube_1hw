package com.example.youtube.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtube.data.remote.ApiService
import com.example.youtube.base.BaseViewModel
import com.example.youtube.data.remote.Repository

import com.example.youtube.model.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel(private val repo:Repository): BaseViewModel() {


    fun  getPlaylistItem(id:String)=repo.getPlayListItems(id)


}