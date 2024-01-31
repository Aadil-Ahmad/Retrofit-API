package com.example.retrofitgetapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitgetapi.R
import com.example.retrofitgetapi.adapter.HorizontalAdapter
import com.example.retrofitgetapi.adapter.MyAdapter
import com.example.retrofitgetapi.common.MyApi
import com.example.retrofitgetapi.databinding.ActivityMainBinding
import com.example.retrofitgetapi.repository.MyRepository
import com.example.retrofitgetapi.viewmodel.MyViewModel
import com.example.retrofitgetapi.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MyAdapter
    private lateinit var horizontalAdapter : HorizontalAdapter
//    private val viewModel: MyViewModel by viewModels()
    private lateinit var viewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, MyViewModelFactory(MyRepository(MyApi.create())))[MyViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setObservable()
    }

    private fun setObservable(){
        viewModel.myData.observe(this, Observer{
            adapter.setData(it)
            horizontalAdapter.setData(it)
        })

        viewModel.onButtonClick.observe(this) { isClicked ->
            if (isClicked){
                viewModel.getModelData()
                setAdapterHorizontal()
                setAdapterVertical()

            }
        }
    }

    private fun setAdapterHorizontal(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        horizontalAdapter = HorizontalAdapter()
        binding.recyclerView.adapter = horizontalAdapter
    }

    private fun setAdapterVertical(){
        binding.recyclerVertical.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter()
        binding.recyclerVertical.adapter = adapter
    }
}