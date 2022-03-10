package com.coolapps.beertuassisment

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coolapps.beertuassisment.model.Beer
import com.coolapps.beertuassisment.network.BeerApi
import kotlinx.coroutines.launch

class MainViewModel :ViewModel(){
    var beerListResponse:List<Beer> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getBearList() {
        viewModelScope.launch {
           val beerApi = BeerApi.getRetroInstance()
            try {
                val beerList = beerApi.getAllBeers()
                beerListResponse = beerList
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}
