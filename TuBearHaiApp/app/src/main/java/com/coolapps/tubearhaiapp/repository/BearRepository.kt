package com.coolapps.tubearhaiapp.repository

import com.coolapps.tubearhaiapp.network.BeerApi
import javax.inject.Inject

class BeerRepository @Inject constructor(private val beerApi: BeerApi){
    suspend fun getAllBeers(per_page : Int,page:Int) =
        beerApi.getAllBeers(per_page,page)

}