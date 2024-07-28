package com.example.ageverification

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ageverification.ui.theme.AgeVerificationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgeVerificationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "firstscreen") {
        composable(route = "firstscreen") {
            first { name, age ->
                navController.navigate("secondscreen/$name/$age")
            }
        }
        composable(route = "secondscreen/{name}/{age}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: "Abhimanyu"
            val age = backStackEntry.arguments?.getString("age")?: "18"
            second(name, age) {
                navController.navigate("firstscreen")
            }
        }
    }
}



