package com.coolapps.beertuassisment.network


import com.coolapps.beertuassisment.model.Beer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface BeerApi {

    @GET("beers")
    suspend fun getAllBeers():List<Beer>

        companion object{
            var beerApi:BeerApi? = null
            fun getRetroInstance() : BeerApi {
                if (beerApi == null){
                    beerApi = Retrofit.Builder()
                        .baseUrl("https://api.punkapi.com/v2/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build().create(BeerApi::class.java)
                }
                return beerApi!!
            }
        }
    }
