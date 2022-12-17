package com.example.youtube.data

import com.example.youtube.BuildConfig
import com.example.youtube.`object`.Constant
import com.example.youtube.model.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlist")
    fun getPlaylist(
    @Query("part") part :String = Constant.PART,
    @Query("channelId") channelId:String= Constant.CHANNEL_ID,
    @Query("key") key:String= BuildConfig.API_KEY,
    @Query("maxResults")maxResults:String=Constant.MAX_RESULT
    ): Call<Playlist>
}