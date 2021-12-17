package com.example.roomwithmvvmdemo

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.example.roomwithmvvmdemo.apidata.ApiModelFactory
import com.example.roomwithmvvmdemo.apidata.ApiRepository
import com.example.roomwithmvvmdemo.apidata.ApiViewModel
import com.example.roomwithmvvmdemo.room.QuoteDatabase

class QuoteApplication : Application() {

    lateinit var repository: ApiRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val apiInterface = ApiInterface.create()
        val quoteDatabase = QuoteDatabase.getDatabase(applicationContext)
         repository = ApiRepository(apiInterface, quoteDatabase)


    }

}