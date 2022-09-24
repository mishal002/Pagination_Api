package com.example.demoapi.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataClient {
    companion object {
        var url = "https://jsonplaceholder.typicode.com/"

        fun getRetrofit(): Retrofit {
            return Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}