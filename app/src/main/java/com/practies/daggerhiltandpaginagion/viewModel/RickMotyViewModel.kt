package com.practies.daggerhiltandpaginagion.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.practies.daggerhiltandpaginagion.api.ApiService
import com.practies.daggerhiltandpaginagion.paging.RickMortyPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RickMotyViewModel @Inject constructor(private val apiService:ApiService):ViewModel() {

val rickiMortyData =Pager(PagingConfig(pageSize = 1)){
    RickMortyPagingSource(apiService)
}.flow.cachedIn(viewModelScope)

//@ExperimentalPagingApi
//val pager=Pager(PagingConfig(pageSize = 50), remoteMediator = MovieRemoteMediator(movieDao,apiService),
//
//){
//        movieDao.gatMovies()
//}.flow.cachedIn(viewModelScope)

}
