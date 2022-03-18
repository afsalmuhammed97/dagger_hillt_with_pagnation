package com.practies.daggerhiltandpaginagion.Di

import com.practies.daggerhiltandpaginagion.Utils.Constants
import com.practies.daggerhiltandpaginagion.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Provides
    @Singleton
    fun providesRetrofitInstance(BASE_URL: String): ApiService =

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

}

//    @Singleton
//    @Provides
//    fun provideMovieDatabase(@ApplicationContext context: Context):MovieDatabase{
//        return  MovieDatabase.getInstance(context)
//    }

//    @Singleton
//    @Provides
//    fun provideMovieDao(movieDatabase: MovieDatabase):MovieDao{
//        return movieDatabase.getMovieDao()
//    }