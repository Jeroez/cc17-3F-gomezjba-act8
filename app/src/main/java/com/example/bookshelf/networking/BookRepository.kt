package com.example.bookshelf.networking

class BookRepository(private val api: BookApi) {
    suspend fun searchBooks(query: String) = api.searchBooks(query)
    suspend fun getBooks() = api.getStaticBooks()
}
