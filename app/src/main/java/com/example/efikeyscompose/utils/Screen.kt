package com.example.efikeyscompose.utils

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Login : Screen("login")
    object Register : Screen("register")
    object VehicleNew : Screen("vehicle new")
    object Site : Screen("site")
    object Keys : Screen("keys")
    object Profile : Screen("profile")
    object Modal : Screen("modal")
    object Parameters : Screen("parameters")
}
