package com.coolapps.tubearhaiapp.screen


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.PagingData
import com.coolapps.tubearhaiapp.model.BeerResponseItem
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.coolapps.tubearhaiapp.component.*
import kotlinx.coroutines.flow.Flow

@ExperimentalMaterialApi
@Composable
fun MainScreen( mainViewModel: MainScreenViewModel,navController: NavController){
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            TuBeerHaiLogo()
            BeerRow(beers = mainViewModel.beers)
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun BeerRow(beers: Flow<PagingData<BeerResponseItem>>) {
    val lazyPagingItems = beers.collectAsLazyPagingItems()

    LazyColumn {

        items(lazyPagingItems) { item ->
            BeerItem(beer = item!!)
        }

        lazyPagingItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { LoadingView(modifier = Modifier.fillParentMaxSize()) }
                }
                loadState.append is LoadState.Loading -> {
                    item { LoadingItem() }
                }
                loadState.refresh is LoadState.Error -> {
                    val e = lazyPagingItems.loadState.refresh as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage!!,
                            modifier = Modifier.fillParentMaxSize(),
                            onClickRetry = { retry() }
                        )
                    }
                }
                loadState.append is LoadState.Error -> {
                    val e = lazyPagingItems.loadState.append as LoadState.Error
                    item {
                        ErrorItem(
                            message = e.error.localizedMessage!!,
                            onClickRetry = { retry() }
                        )
                    }
                }
            }
        }
    }
}










