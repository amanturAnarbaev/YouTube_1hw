package com.example.youtube.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.youtube.model.Playlist
import com.example.youtube.network.Resource
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private val apiService: ApiService by lazy {
        RetrofitClient.create()
    }

    fun getPlayList(): LiveData<Resource<Playlist>> = liveData(Dispatchers.IO) {
        emit(Resource.loading())

        val result = apiService.getPlaylist()

        if (result.isSuccessful) {
            emit(Resource.success(result.body()))
        } else {
            emit(Resource.error(result.message()))
        }


    }

    fun getPlayListItems(playlistId: String): LiveData<Resource<Playlist>> =
        liveData(Dispatchers.IO) {
            emit(Resource.loading())
            val result = apiService.getPlaylistItems(playlistId = playlistId)

            if (result.isSuccessful) {
                emit(Resource.success(result.body()))
            } else {
                emit(Resource.error(result.message()))
            }

        }
}