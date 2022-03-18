package com.practies.daggerhiltandpaginagion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.practies.daggerhiltandpaginagion.adapter.MoviePageAdapter
import com.practies.daggerhiltandpaginagion.adapter.RickMortyPageAdapter
import com.practies.daggerhiltandpaginagion.databinding.ActivityMainBinding
import com.practies.daggerhiltandpaginagion.viewModel.RickMotyViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import okhttp3.internal.wait

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var pageAdapter: RickMortyPageAdapter
    private  val viewModel:RickMotyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUpView()
        loadingData()
    }



    private fun loadingData() {


        lifecycleScope.launch {
//            viewModel.pager.collect { pagingData->
//                pageAdapter.submitData(pagingData)
//
//            }
            viewModel.rickiMortyData.collect { pagingData->
                pageAdapter.submitData(pagingData)

            }
        }
    }


    private fun setUpView(){
        pageAdapter= RickMortyPageAdapter()
        binding.recyclerView.apply {
            layoutManager=StaggeredGridLayoutManager(
                2,StaggeredGridLayoutManager.VERTICAL
            )
            adapter=pageAdapter
            setHasFixedSize(true)

        }
    }

}