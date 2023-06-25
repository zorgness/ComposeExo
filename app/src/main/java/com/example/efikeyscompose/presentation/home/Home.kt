package com.example.efikeyscompose.presentation.home

import HomeHeader
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.efikeyscompose.R
import com.example.efikeyscompose.presentation.ui.theme.ColorAccent
import com.example.efikeyscompose.presentation.ui.theme.EfiKeysComposeTheme
import com.example.efikeyscompose.utils.Screen

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: MainViewModel
) {


    LaunchedEffect(true) {
        viewModel.goToLoginSharedFlow.collect {
            navController.navigate(it.route) {
                popUpTo(Screen.Home.route) {
                    inclusive = true
                }
            }
        }
    }

    HomeContent() {
        viewModel.logout()
    }
}

@Composable
fun HomeContent(

    handleLogout: () -> Unit
) {
    val imageUrl = "https://www.realisaprint.com/blog/wp-content/uploads/2018/04/impression-garage-automobile.jpg"
    val garageName = "Speedy Charles de Fitte"
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HomeHeader(
            onLogoutIconClicked = { handleLogout() }
        )

        Box() {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(168.dp),
                contentScale = ContentScale.FillWidth,
                colorFilter = ColorFilter.tint(
                    color = Color.Black.copy(alpha = 0.3f),
                    blendMode = BlendMode.Darken

                )
            )

            Text(
                text = garageName,
                style = MaterialTheme.typography.h3,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .width(240.dp)
                    .padding(20.dp)
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(28.dp)
                .clip(
                    shape = RoundedCornerShape(
                        bottomStart = 20.dp,
                        bottomEnd = 20.dp
                    )
                )
                .background(ColorAccent)
        ) {
            Text(
                text = "Changer de site",
                color = Color.White,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.align(Alignment.Center)
            )

        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp, vertical = 24.dp)
                .height(44.dp),
            onClick = { /*TODO*/ }
        ) {
            Text(
                text = "Ajouter un véhicule au garage",
                style = MaterialTheme.typography.h4
            )
        }

        Row(
            modifier = Modifier.padding(start = 10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(shape = RoundedCornerShape(12.dp))
                    .background(ColorAccent)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.key_icon) ,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(28.dp)
                )

            }
            Text(
                text = "Clés en votre possesion",
                modifier = Modifier.padding(start = 10.dp),
                style = MaterialTheme.typography.h4
            )

        }

    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EfiKeysComposeTheme {
        HomeContent {

        }
    }
}