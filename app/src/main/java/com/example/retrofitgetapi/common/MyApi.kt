package com.example.retrofitgetapi.common

import com.example.retrofitgetapi.retrofit.MyApiServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyApi {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    fun create(): MyApiServices{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(MyApiServices::class.java)
    }
}