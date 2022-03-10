package com.coolapps.tubearhaiapp.navigation

enum class BeerScreens {
    MainScreen;

    companion object{
        fun fromRoute(route: String?):BeerScreens = when(route?.substringBefore("/")){

          MainScreen.name ->MainScreen
            null -> MainScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}