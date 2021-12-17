package com.example.roomwithmvvmdemo.apidata

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomwithmvvmdemo.all_states.AllStates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ApiViewModel(private val repository: ApiRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getData()
        }

    }

    val states: LiveData<AllStates>
        get() = repository.quotes

    val erro: LiveData<String>
        get() = repository.mistakes
}