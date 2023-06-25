package com.example.efikeyscompose.utils

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Login : Screen("login")
    object Register : Screen("register")
    object AddVehicle : Screen("add_vehicle")
}