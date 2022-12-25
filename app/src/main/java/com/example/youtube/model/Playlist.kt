package com.example.youtube.model

data class Playlist(
    val etag: String?, // 63AGyPEfefXwgymKfyOyTryAQeU
    val items: List<Item>?,
    val kind: String?, // youtube#playlistListResponse
    val nextPageToken: String?, // CAcQAA
    val pageInfo: PageInfo?
)