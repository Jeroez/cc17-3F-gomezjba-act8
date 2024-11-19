package com.example.bookshelf.networking

import com.squareup.moshi.Json

data class Book(
    val id: String,
    @Json(name = "volumeInfo") val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    val title: String,
    @Json(name = "imageLinks") val imageLinks: ImageLinks?
)

data class ImageLinks(
    @Json(name = "thumbnail") val thumbnail: String
)
