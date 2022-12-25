package com.example.youtube.base.ui.detail.playlist


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtube.base.BaseViewModel
import com.example.youtube.data.ApiService
import com.example.youtube.data.remote.RetrofitClient
import com.example.youtube.model.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlayListViewModel : BaseViewModel() {
    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun getPlayList():LiveData<Playlist>{
        val data= MutableLiveData<Playlist>()
        apiService.getPlaylist().enqueue(object :Callback<Playlist>{
            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                if(response.isSuccessful){
                    data.value = response.body()
                }

            }

            override fun onFailure(call: Call<Playlist>, t: Throwable) {

            }



        })
    return data}
}