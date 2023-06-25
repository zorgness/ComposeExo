package com.example.efikeyscompose.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.efikeyscompose.R
import com.example.efikeyscompose.presentation.ui.theme.EfiKeysComposeTheme
import com.example.efikeyscompose.utils.Screen


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
            modifier = Modifier
                .fillMaxWidth()
                .padding(top= 10.dp)
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