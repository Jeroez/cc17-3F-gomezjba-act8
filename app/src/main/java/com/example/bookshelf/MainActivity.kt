package com.example.bookshelf

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.bookshelf.networking.BookRepository
import com.example.bookshelf.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val bookViewModel: BookViewModel by lazy {
        val repository = BookRepository(RetrofitInstance.api)
        ViewModelProvider(this, BookViewModel.Factory(repository)).get(BookViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bookViewModel.searchBooks("jazz history").observe(this) { response ->
            response?.items?.forEach {
                println(it.volumeInfo.title)
            }
        }
    }
}
