package com.coolapps.tubearhaiapp.screen

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.coolapps.tubearhaiapp.model.BeerResponse
import com.coolapps.tubearhaiapp.model.BeerResponseItem
import com.coolapps.tubearhaiapp.repository.BeerPaging
import com.coolapps.tubearhaiapp.repository.BeerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(beerRepository: BeerRepository): ViewModel(){

    val beers: Flow<PagingData<BeerResponseItem>> = Pager(PagingConfig(pageSize = 20)) {
        BeerPaging(beerRepository)
    }.flow

  
}