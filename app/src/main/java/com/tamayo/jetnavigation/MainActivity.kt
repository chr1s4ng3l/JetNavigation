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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

                    NavHost(navController = navigationController, startDestination = "screenOne") {
                        composable("screenOne"){
                            ScreenOne(navigationController)
                        }

                        composable("screenTwo"){
                            ScreenTwo(navigationController)
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
            .background(Color.Green).clickable{navController.navigate("screenTwo")}
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
            .background(Color.Blue).clickable{navController.navigate("screenOne")}
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetNavigationTheme {
        //ScreenOne()
    }
}