package com.example.efikeyscompose

import LoginScreen
import com.example.efikeyscompose.presentation.auth.register.RegisterScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.efikeyscompose.presentation.auth.login.LoginViewModel
import com.example.efikeyscompose.presentation.home.HomeScreen
import com.example.efikeyscompose.presentation.home.MainViewModel
import com.example.efikeyscompose.presentation.auth.register.RegisterViewModel
import com.example.efikeyscompose.presentation.splash.SplashScreen
import com.example.efikeyscompose.presentation.splash.SplashViewModel
import com.example.efikeyscompose.presentation.ui.theme.EfiKeysComposeTheme
import com.example.efikeyscompose.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EfiKeysComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) {
            val splashViewModel: SplashViewModel = hiltViewModel()
            SplashScreen(navController, splashViewModel)
        }
        composable(Screen.Register.route) {
            val registerViewModel: RegisterViewModel = hiltViewModel()
            RegisterScreen(navController, registerViewModel)
        }
        composable(Screen.Login.route) {
            val loginViewModel: LoginViewModel = hiltViewModel()
            LoginScreen(navController, loginViewModel)
        }
        composable(Screen.Home.route) {
            val mainViewModel: MainViewModel = hiltViewModel()
            HomeScreen(navController, mainViewModel)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EfiKeysComposeTheme {

    }
}