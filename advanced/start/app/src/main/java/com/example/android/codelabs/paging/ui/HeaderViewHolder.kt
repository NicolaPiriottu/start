package com.example.android.codelabs.paging.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.codelabs.paging.PostUIItem
import com.example.android.codelabs.paging.databinding.HeaderViewItemBinding

class HeaderViewHolder(private val binding: HeaderViewItemBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(item: PostUIItem.Header){
        binding.header.text = item.title
    }

    companion object {
        fun getLayoutInflated(parent: ViewGroup): HeaderViewItemBinding {
            val inflater = LayoutInflater.from(parent.context)

            return HeaderViewItemBinding.inflate(
                inflater,
                parent,
                false
            )
        }
    }
}