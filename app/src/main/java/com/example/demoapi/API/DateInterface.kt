package com.example.demoapi.API

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DateInterface {

    @GET("comments")
    fun getData(@Query("postId") id : String):Call<List<DataApiModelItem>>
}