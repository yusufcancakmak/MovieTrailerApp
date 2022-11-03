package com.yusufcancakmak.mvvmmovieapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.yusufcancakmak.mvvmmovieapp.databinding.TvShowLayoutItemBinding
import com.yusufcancakmak.mvvmmovieapp.model.TvShowItem

class TvShowAdapter:RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: TvShowLayoutItemBinding):RecyclerView.ViewHolder(binding.root)

    private val diffcallback =object :DiffUtil.ItemCallback<TvShowItem>(){
        override fun areItemsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return oldItem.id ==newItem.id
        }
        override fun areContentsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return  newItem ==oldItem
        }
    }
    private val differ=AsyncListDiffer(this,diffcallback)
    var tvShows:List<TvShowItem>
    get() = differ.currentList
    set(value){
        differ.submitList(value)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(TvShowLayoutItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTvShow=tvShows[position]
        holder.binding.apply {
            textView.text=currentTvShow.name.toString()
            imageView.load(currentTvShow.image.original){
                crossfade(true)
                crossfade(1000)
            }
        }
    }
    override fun getItemCount() = tvShows.size
}