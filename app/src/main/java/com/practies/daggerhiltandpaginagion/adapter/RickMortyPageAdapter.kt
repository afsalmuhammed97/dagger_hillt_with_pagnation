package com.practies.daggerhiltandpaginagion.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.DifferCallback
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.practies.daggerhiltandpaginagion.Model.RickMorty
import com.practies.daggerhiltandpaginagion.databinding.RickMortyItemBinding

class RickMortyPageAdapter:PagingDataAdapter<RickMorty, RickMortyPageAdapter.MyViewHolder>(diffCallback) {

inner class MyViewHolder(val binding: RickMortyItemBinding):RecyclerView.ViewHolder(binding.root)

    companion object{
        val diffCallback=object :DiffUtil.ItemCallback<RickMorty>(){
            override fun areItemsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
                 return    oldItem.id==newItem.id
            }

            override fun areContentsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
               return  oldItem==newItem
            }

        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem= getItem(position)
        holder.binding.apply {
            textView.text="${currentItem?.name}"
            val imageLink=currentItem?.image

            imageView.load(imageLink){
                crossfade(true)
                crossfade(500)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return  MyViewHolder(
           RickMortyItemBinding.inflate(
               LayoutInflater.from(parent.context),parent,false
           )
       )
    }
}