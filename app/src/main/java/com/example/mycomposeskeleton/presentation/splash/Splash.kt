package com.example.mycomposeskeleton.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mycomposeskeleton.R
import com.example.mycomposeskeleton.presentation.ui.theme.EfiKeysComposeTheme
import com.example.mycomposeskeleton.utils.Screen


@Composable
fun SplashScreen(
    navController: NavHostController,
    viewModel: SplashViewModel
) {

    LaunchedEffect(true ) {
        viewModel.goToScreen.collect {
            navController.navigate(it.route) {
                popUpTo(Screen.Splash.route) {
                    inclusive = true
                }
            }
        }
    }

    viewModel.initSplash()
    SplashContent()

}

@Composable
fun SplashContent() {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.efikeys_logo) ,
            contentDescription = null,
            modifier = Modifier.padding(top= 10.dp)
        )

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EfiKeysComposeTheme {
        SplashContent()
    }
}