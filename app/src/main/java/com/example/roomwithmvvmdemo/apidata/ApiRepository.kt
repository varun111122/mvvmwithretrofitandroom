package com.example.roomwithmvvmdemo.apidata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.roomwithmvvmdemo.ApiInterface
import com.example.roomwithmvvmdemo.all_states.AllStates
import com.example.roomwithmvvmdemo.room.QuoteDatabase
import androidx.core.content.ContextCompat.getSystemService

import android.net.ConnectivityManager
import androidx.core.content.ContextCompat


class ApiRepository(
    private val apiInterface: ApiInterface,
    private val quoteDatabase: QuoteDatabase
) {

    private var allData = MutableLiveData<AllStates>()
    private var error = MutableLiveData<String>()

    val quotes: LiveData<AllStates>
        get() = allData

    val mistakes: LiveData<String>
        get() = error

    suspend fun getData() {
        val response = apiInterface.getAllStates()
        if (response.isSuccessful) {
            val result = response.body()
            quoteDatabase.quoteDao().insertQuote(response.body()!!.data)
            allData.postValue(result!!)
        } else {
            error.postValue(response.body()!!.message)
        }

    }



}