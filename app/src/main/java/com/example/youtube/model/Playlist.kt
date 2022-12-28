package com.example.youtube.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class Playlist(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val etag: String?, // 63AGyPEfefXwgymKfyOyTryAQeU
    val items: List<Item>? = null,
    val kind: String?, // youtube#playlistListResponse
    val nextPageToken: String?, // CAcQAA
    val pageInfo: PageInfo?
) {

}