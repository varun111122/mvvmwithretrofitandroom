package com.example.roomwithmvvmdemo

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomwithmvvmdemo.apidata.ApiModelFactory
import com.example.roomwithmvvmdemo.apidata.ApiRepository
import com.example.roomwithmvvmdemo.apidata.ApiViewModel

class MainActivity2 : AppCompatActivity() {
    lateinit var viewModel: ApiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val repository = (application as QuoteApplication).repository
        viewModel =
            ViewModelProvider(this, ApiModelFactory(repository)).get(ApiViewModel::class.java)

        viewModel.states.observe(this, Observer {
            Log.e("varunapi", it.data.toString())
        })
        viewModel.erro.observe(this, Observer {
            Log.e("varunapi", it.toString())
        })
    }
}