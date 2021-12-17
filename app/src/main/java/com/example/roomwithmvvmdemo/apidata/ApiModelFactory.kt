package com.example.roomwithmvvmdemo.apidata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ApiModelFactory(private val repository: ApiRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ApiViewModel(repository) as T
    }
}