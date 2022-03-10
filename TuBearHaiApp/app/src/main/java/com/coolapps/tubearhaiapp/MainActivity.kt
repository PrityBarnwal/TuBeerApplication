package com.coolapps.tubearhaiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.coolapps.tubearhaiapp.navigation.BeerNavigation
import com.coolapps.tubearhaiapp.ui.theme.TuBearHaiAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TuBearHaiAppTheme {
              BeerNavigation()
                }
            }
        }
    }

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TuBearHaiAppTheme {

    }
}