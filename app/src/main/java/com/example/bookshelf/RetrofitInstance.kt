package com.example.bookshelf

import com.example.bookshelf.networking.BookApi
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://www.googleapis.com/books/v1/"

    private val moshi: Moshi by lazy {
        Moshi.Builder().build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    val api: BookApi by lazy {
        retrofit.create(BookApi::class.java)
    }
}
