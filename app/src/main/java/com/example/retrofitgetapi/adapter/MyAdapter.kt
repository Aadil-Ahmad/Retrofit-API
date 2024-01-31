package com.example.retrofitgetapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitgetapi.R
import com.example.retrofitgetapi.databinding.ListItemBinding
import com.example.retrofitgetapi.model.MyDataModel

class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var data: List<MyDataModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent. context)
        val binding: ListItemBinding = DataBindingUtil.inflate(inflater, R.layout.list_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(newData : List<MyDataModel>){
        data =  newData
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: MyDataModel){
            binding.itemModel = item
            binding.executePendingBindings()
        }
    }

}