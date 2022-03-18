package com.practies.daggerhiltandpaginagion.api


import com.practies.daggerhiltandpaginagion.Model.ResponseApi
import com.practies.daggerhiltandpaginagion.Utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getAllCharecters(
        @Query("page")page:Int
    ):Response<ResponseApi>




//    @GET("upcoming?")
//    suspend  fun  getUpComingMovies(
//        @Query("page")page:Int,
//        @Query("api_key")key:String =APIKEY):Response<MovieResponse>

}