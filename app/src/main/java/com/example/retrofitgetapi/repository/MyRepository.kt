package com.example.retrofitgetapi.repository

import com.example.retrofitgetapi.model.MyDataModel
import com.example.retrofitgetapi.retrofit.MyApiServices

class MyRepository(private val apiServices: MyApiServices) {

    suspend fun getMyData(): List<MyDataModel>{
        return apiServices.getMyData()
    }
}