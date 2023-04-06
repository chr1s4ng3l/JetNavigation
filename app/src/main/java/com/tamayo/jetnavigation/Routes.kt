package com.tamayo.jetnavigation

sealed class Routes(val route: String) {
    object Screen1 : Routes("ScreenOne")
    object Screen2 : Routes("ScreenTwo")
    object Screen3 : Routes("ScreenThree")
    object Screen4 : Routes("ScreenFour/{age}") {
        fun createRoute(age: Int) = "ScreenFour/$age"
    }
    object Screen5 : Routes("ScreenFive?name={name}") {
        fun createRoute(name: String) = "ScreenFive?name=$name"
    }
}
