package com.example.revestretailassignment.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.revestretailassignment.presentation.navigation.RRNavGraph
import com.example.revestretailassignment.ui.theme.Purple40
import com.example.revestretailassignment.ui.theme.PurpleGrey80
import com.example.revestretailassignment.ui.theme.RevestRetailAssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RevestRetailAssignmentTheme {
                window.statusBarColor =  Purple40.toArgb()
                window.navigationBarColor = Purple40.toArgb()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = PurpleGrey80
                ) {
                    RRNavGraph(navController = rememberNavController())
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RevestRetailAssignmentTheme {
        Greeting("Android")
    }
}