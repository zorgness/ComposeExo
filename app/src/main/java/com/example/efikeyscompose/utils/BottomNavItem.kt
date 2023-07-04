package com.example.efikeyscompose.utils

import androidx.compose.ui.graphics.Color
import com.example.efikeyscompose.R
import com.example.efikeyscompose.presentation.ui.theme.ColorAccent

sealed class BottomNavItem(
    var icon: Int,
    var screenRoute: String,
    var color: Color
) {
    object Home : BottomNavItem(R.drawable.home_icon, Screen.Home.route, ColorAccent)
    object Keys: BottomNavItem(R.drawable.key_icon, Screen.Keys.route, Color.White)
    object Profile: BottomNavItem(R.drawable.userfeedback_icon, Screen.Profile.route, Color.White)
}
