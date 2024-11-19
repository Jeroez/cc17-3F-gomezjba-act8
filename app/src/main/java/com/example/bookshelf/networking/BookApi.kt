package com.example.bookshelf.networking

import retrofit2.http.GET

interface BookApi {
    @GET("volumes?q=jazz+history")
    suspend fun getBooks(): BookResponse
}
