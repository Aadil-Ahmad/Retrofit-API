package com.example.retrofitgetapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitgetapi.model.MyDataModel
import com.example.retrofitgetapi.repository.MyRepository
import kotlinx.coroutines.launch

class MyViewModel(private val repository: MyRepository): ViewModel() {

    val myData = MutableLiveData<List<MyDataModel>>()
    val onButtonClick = MutableLiveData<Boolean>()
    fun getData(){
        viewModelScope.launch {
            onButtonClick.value = true
        }
    }

    /*fun getModelData(){
        viewModelScope.launch {
            myData.value = listOf(
                MyDataModel(1, "aadar", "dar"),
                MyDataModel(2, "aadar", "dar"),
                MyDataModel(3, "aadar", "dar"),
                MyDataModel(4, "aadar", "dar"),
            )
        }
    }*/

    fun getModelData(){
        viewModelScope.launch {
            myData.value = repository.getMyData().toList()
        }
    }
}