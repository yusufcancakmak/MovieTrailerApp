package com.yusufcancakmak.mvvmmovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yusufcancakmak.mvvmmovieapp.adapter.TvShowAdapter
import com.yusufcancakmak.mvvmmovieapp.databinding.ActivityMainBinding
import com.yusufcancakmak.mvvmmovieapp.viewmodel.TvShowViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel:TvShowViewModel by viewModels()
    private lateinit var tvShowAdapter: TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       setupRv()
    }
    private fun setupRv(){
        tvShowAdapter= TvShowAdapter()
        binding.recyclerview.apply {
            adapter = tvShowAdapter
         layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
        setHasFixedSize(true)
        }
        viewModel.responceTvShow.observe(this,{listtvShows ->



        })
        binding.recyclerviewEpsodies.apply {
            adapter = tvShowAdapter
            layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(true)
        }
        viewModel.responceTvShow.observe(this,{listtvShows ->



        })
        binding.recyclerviewRecentlyadded.apply {
            adapter = tvShowAdapter
            layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(true)
        }
        viewModel.responceTvShow.observe(this,{listtvShows ->

            tvShowAdapter.tvShows=listtvShows

        })
    }
}