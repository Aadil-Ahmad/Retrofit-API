package com.example.retrofitgetapi.retrofit

import com.example.retrofitgetapi.model.MyDataModel
import retrofit2.http.GET

interface MyApiServices {

    @GET("posts")
    suspend fun getMyData(): List<MyDataModel>
}