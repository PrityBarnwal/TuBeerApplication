package com.coolapps.beertuassisment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.coolapps.beertuassisment.model.Beer
import com.coolapps.beertuassisment.ui.theme.BeerTuAssismentTheme

class MainActivity : ComponentActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeerTuAssismentTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen(beerList = mainViewModel.beerListResponse)
                    mainViewModel.getBearList()
                }
            }
        }
    }
}
@ExperimentalMaterialApi
@Composable
fun MainScreen (beerList: List<Beer>) {
  //  val beer=Beer("Developer,s Says","Hi Guys!! Please Like","","Great Beer")
    var selectedIndex by remember { mutableStateOf(-1) }
    LazyColumn {
        itemsIndexed(items = beerList) { index, item ->
            BeerCollection(beer = item)
            }

        }

    }

