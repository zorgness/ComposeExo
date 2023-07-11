package com.example.efikeyscompose.presentation.profile

import BottomNavigationComponent
import CustomTextField
import HeaderSimple
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.efikeyscompose.R
import com.example.efikeyscompose.data.dto.UserDto
import com.example.efikeyscompose.presentation.ui.theme.EfiKeysComposeTheme
import com.example.efikeyscompose.utils.Screen

@Composable
fun ProfileScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel
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
    ProfileContent(
        navController = navController,
        account = UserDto.SAMPLE,
        handleLogout = { viewModel.logout() }

    )
}

@Composable
fun ProfileContent(
    navController: NavHostController,
    account: UserDto,
    handleLogout: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderSimple(
            title = "Compte",
            modifier = Modifier.align(Alignment.TopCenter)
        )
        
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(vertical = 75.dp)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.padding(top = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(id = R.drawable.profil_icon ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(shape = CircleShape)
                )
                Text(
                    text = account.username,
                    style = MaterialTheme.typography.h1
                )
            }


            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .height(240.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                CustomTextField(placeholder = "email", value = account.email, handleValue = {})
                CustomTextField(placeholder = "username", value = account.username, handleValue = {})
                CustomTextField(placeholder = "mot de passe", value = "123456", isPassword = true, handleValue = {})
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 40.dp)
                    .height(48.dp),
                onClick = { handleLogout() }
            ) {
                Text(text = "Se déconnecter")
            }
            
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            BottomNavigationComponent(
                navController = navController
            )
        }
    }
}


/*
@Preview(showBackground = true)
@Composable
fun com.example.efikeyscompose.presentation.parameters.components.DefaultPreview() {
    EfiKeysComposeTheme {
        
        ProfileContent(
            navController = NavHostController(LocalContext.current),
            account = UserDto.SAMPLE,
            handleLogout = {}
        )
        
    }
}*/
