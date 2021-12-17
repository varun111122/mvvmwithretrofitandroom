package com.example.roomwithmvvmdemo

import com.example.roomwithmvvmdemo.all_states.AllStates
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import retrofit2.http.POST
import retrofit2.Response
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Call
import java.util.concurrent.TimeUnit


interface ApiInterface {


    @GET("all_counties")
    suspend fun getAllStates(): Response<AllStates>

    companion object {
        var BASE_URL = "https://phpstack-102119-1338804.cloudwaysapps.com/api/"
        fun create(): ApiInterface {
            val interceptor = HttpLoggingInterceptor()
//            interceptor.level = HttpLoggingInterceptor.Level.BODY
            if(BuildConfig.DEBUG){
                //print the logs in this case
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            }else{
                interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
            }

            var client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            val builder = OkHttpClient.Builder()
            builder.addInterceptor(interceptor)
            builder.connectTimeout(2, TimeUnit.MINUTES)
            builder.readTimeout(2, TimeUnit.MINUTES)
            builder.writeTimeout(2, TimeUnit.MINUTES)
            client = builder.build()


            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(client)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}