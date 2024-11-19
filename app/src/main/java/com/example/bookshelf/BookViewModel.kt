package com.example.bookshelf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.bookshelf.networking.BookRepository
import kotlinx.coroutines.Dispatchers

class BookViewModel(private val repository: BookRepository) : ViewModel() {
    fun searchBooks(query: String) = liveData(Dispatchers.IO) {
        emit(repository.searchBooks(query))
    }

    class Factory(private val repository: BookRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(BookViewModel::class.java)) {
                return BookViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
