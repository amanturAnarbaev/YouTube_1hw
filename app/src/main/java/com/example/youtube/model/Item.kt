package com.example.youtube.model

data class Item(
    val contentDetails: ContentDetails?,
    val etag: String?, // 7JpCuc3GPyYuerjQU2Rx7P5yKUk
    val id: String?, // PLoSWVnSA9vG8F36IUVWkWIzUN0M9BGG_c
    val kind: String?, // youtube#playlist
    val snippet: Snippet?
)