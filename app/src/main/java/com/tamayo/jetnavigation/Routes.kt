package com.tamayo.jetnavigation

sealed class Routes(val route: String){
    object Screen1: Routes("ScreenOne")
    object Screen2: Routes("ScreenTwo")
}
