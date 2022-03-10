package com.coolapps.tubearhaiapp.network

import com.coolapps.tubearhaiapp.model.BeerResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface BeerApi {
//https://api.punkapi.com/v2/beers?page=2&per_page=80
    @GET("beers")
    suspend fun getAllBeers(
    @Query("page") page: Int,
    @Query("per_page") per_page: Int
    ) :List<BeerResponseItem>

}
