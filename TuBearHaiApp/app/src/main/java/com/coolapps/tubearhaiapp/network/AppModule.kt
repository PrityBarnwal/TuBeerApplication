package com.coolapps.tubearhaiapp.network

import com.coolapps.tubearhaiapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
  //  "https://api.punkapi.com/v2/beers?page=2&per_page=80"


    @Provides
    @Singleton
    fun getRetroInstance(): BeerApi {
        return Retrofit.Builder()
        .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BeerApi::class.java)
    }
}