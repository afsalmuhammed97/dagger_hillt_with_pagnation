package com.practies.daggerhiltandpaginagion.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.practies.daggerhiltandpaginagion.Model.RickMorty
import com.practies.daggerhiltandpaginagion.api.ApiService

class RickMortyPagingSource
    (private val apiService: ApiService):PagingSource<Int,RickMorty>() {
    override fun getRefreshKey(state: PagingState<Int, RickMorty>): Int? {

        return  null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RickMorty> {


        return  try {
            val currentPage=params.key?:1
            val response=apiService.getAllCharecters(currentPage)

            val data =response.body()?.results?: emptyList()
            val responseData= mutableListOf<RickMorty>()
              responseData.addAll(data)

            LoadResult.Page(
                data=responseData,
                prevKey = if (currentPage==1) null else -1,
                nextKey = currentPage.plus(1)
            )

        }catch (e:Exception){
            LoadResult.Error(e)
        }


    }

}