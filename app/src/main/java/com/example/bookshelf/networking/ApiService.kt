package com.example.bookshelf.networking
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{
    @GET("books/v1/volumes")
    fun getBooks(@Query("q") query: String): Call<BookResponse>
}
