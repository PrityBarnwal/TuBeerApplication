package com.coolapps.tubearhaiapp.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coolapps.tubearhaiapp.screen.MainScreen
import com.coolapps.tubearhaiapp.screen.MainScreenViewModel


@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun BeerNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = BeerScreens.MainScreen.name){
        composable(BeerScreens.MainScreen.name){
            val mainScreenViewModel = hiltViewModel<MainScreenViewModel>()
            MainScreen(navController = navController,mainViewModel = mainScreenViewModel)
        }

        }
    }