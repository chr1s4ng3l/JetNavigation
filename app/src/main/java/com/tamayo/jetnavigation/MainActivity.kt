package com.tamayo.jetnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tamayo.jetnavigation.ui.theme.JetNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNavigationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navigationController = rememberNavController()

                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.Screen1.route
                    ) {
                        composable(Routes.Screen1.route) { ScreenOne(navigationController) }
                        composable(Routes.Screen2.route) { ScreenTwo(navigationController) }
                        composable(Routes.Screen3.route) { ScreenThree(navigationController) }
                        composable(
                            Routes.Screen4.route,
                            arguments = listOf(navArgument("age") { type = NavType.IntType })
                        ) { backStackEntry ->
                            ScreenFour(
                                navigationController,
                                backStackEntry.arguments?.getInt("age") ?: 0

                            )
                        }

                        composable(
                            Routes.Screen5.route,
                            arguments = listOf(navArgument("name") {defaultValue = "Sin Nombre"})
                        ) { backStackEntry ->
                            ScreenFive(
                                navController = navigationController,
                                name = backStackEntry.arguments?.getString("name")
                            )
                        }
                    }

                }
            }
        }
    }
}

@Composable
fun ScreenOne(navController: NavController) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
            .clickable { navController.navigate(Routes.Screen2.route) }
    ) {
        Text(
            text = "Screen One 1",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 32.sp
        )
    }

}

@Composable
fun ScreenTwo(navController: NavController) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue)
            .clickable { navController.navigate(Routes.Screen3.route) }
    ) {
        Text(
            text = "Screen Two 2",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 32.sp
        )
    }

}

@Composable
fun ScreenThree(navController: NavController) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
            .clickable { navController.navigate(Routes.Screen4.createRoute(24)) }
    ) {
        Text(
            text = "Screen Three 3",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 32.sp
        )
    }
}

@Composable
fun ScreenFour(navController: NavController, name: Int) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .clickable { navController.navigate(Routes.Screen5.createRoute("Christopher")) }
    ) {
        Text(
            text = "I am $name",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 32.sp
        )
    }

}

@Composable
fun ScreenFive(navController: NavController, name: String?) {
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .clickable { }
    ) {
        Text(
            text = "My name is $name",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 32.sp
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetNavigationTheme {
        //ScreenOne()
    }
}