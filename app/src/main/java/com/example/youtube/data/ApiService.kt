package com.example.youtube.data


import com.example.youtube.BuildConfig
import com.example.youtube.`object`.Constant
import com.example.youtube.model.Playlist
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
    fun getPlaylist(
        @Query("part") part: String = Constant.PART,
        @Query("channelId") channelId: String = Constant.CHANNEL_ID,
        @Query("maxResults") maxResults: String = Constant.MAX_RESULTS,
        @Query("key") key: String = BuildConfig.API_KEY,
    ): Call<Playlist>

    @GET("playlistItems")
    fun getPlaylistItems(
        @Query("part") part: String = Constant.PART,
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("playlistId") playlistId: String,
        @Query("maxResults") maxResults: String = Constant.MAX_RESULTS,
    ): Call<Playlist>
}