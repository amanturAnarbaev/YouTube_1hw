package com.example.youtube.PostMan.Playlist

data class playList(
    val etag: String,
    val items: List<Item>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfo
)