package com.example.efikeyscompose.presentation.auth.register

import CustomTextField
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.example.efikeyscompose.R
import com.example.efikeyscompose.presentation.ui.theme.ColorPrimary
import com.example.efikeyscompose.presentation.ui.theme.EfiKeysComposeTheme
import com.example.efikeyscompose.utils.Screen

@Composable
fun RegisterScreen(
    navController: NavHostController,
    viewModel: RegisterViewModel
) {
    val email by viewModel.emailStateFlow.collectAsState("")
    val username by viewModel.usernameStateFlow.collectAsState("")
    val password by viewModel.passwordStateFlow.collectAsState("")
    val confirm by viewModel.confirmStateFlow.collectAsState("")

    val context = LocalContext.current

    LaunchedEffect(true) {
        viewModel.goToLoginSharedFlow.collect {
            navController.navigate(it.route) {
                popUpTo(it.route) {
                    inclusive = true
                }
            }
        }
    }

    LaunchedEffect(true) {
        viewModel.registerStateSharedFlow.collect { message->
            when(message) {
                RegisterViewModel.RegisterState.SUCCESS -> R.string.account_success
                RegisterViewModel.RegisterState.FAILURE -> R.string.account_failed
                RegisterViewModel.RegisterState.ERROR_SERVER -> R.string.error_server
                RegisterViewModel.RegisterState.ERROR_CONNECTION -> R.string.error_connection
                RegisterViewModel.RegisterState.ERROR_CONFIRMATION -> R.string.error_confirmation
                RegisterViewModel.RegisterState.EMPTY_FIELDS -> R.string.empty_fields
                RegisterViewModel.RegisterState.ERROR_SERVICE -> R.string.error_service
                RegisterViewModel.RegisterState.ERROR_PARAM -> R.string.error_param
                RegisterViewModel.RegisterState.LOGIN_USED -> R.string.login_used

            }.let {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    RegisterContent(
        context = context,
        email = email,
        username = username,
        password = password,
        confirm = confirm,
        handleEmail = { viewModel.updateEmail(it) },
        handleUsername = { viewModel.updateUsername(it) },
        handlePassword = { viewModel.updatePassword(it) },
        handleConfirm = { viewModel.updateConfirm(it) },
        handleClick = { viewModel.register() },
        goToLogin = {
            navController.navigate(Screen.Login.route)
        }
    )
}

@Composable
fun RegisterContent(
    context: Context,
    email: String,
    username: String,
    password: String,
    confirm: String,
    handleEmail: (String) -> Unit,
    handleUsername: (String) -> Unit,
    handlePassword: (String) -> Unit,
    handleConfirm: (String) -> Unit,
    handleClick: () -> Unit,
    goToLogin: () -> Unit
) {



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.efikeys_logo),
            contentDescription = null,
            modifier = Modifier
                .padding(top= 10.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = context.getString(R.string.new_account),
            style = MaterialTheme.typography.h2,

        )
        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier.fillMaxHeight()
        ) {

            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .align(Alignment.TopCenter),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CustomTextField(
                    placeholder = context.getString(R.string.email),
                    value = email,
                    handleValue = { handleEmail(it) }
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(
                    placeholder = context.getString(R.string.username),
                    value = username,
                    handleValue = { handleUsername(it) }
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(
                    placeholder = context.getString(R.string.password),
                    value = password,
                    isPassword = true,
                    handleValue = { handlePassword(it) }
                )
                Spacer(modifier = Modifier.height(20.dp))
                CustomTextField(
                    placeholder = context.getString(R.string.confirm_password),
                    value = confirm,
                    isPassword = true,
                    handleValue = { handleConfirm(it) }
                )
                Spacer(modifier = Modifier.height(30.dp))

            }


            Column(
                modifier = Modifier
                    .padding(bottom = 40.dp, top= 40.dp)
                    .align(Alignment.BottomCenter),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .padding(horizontal = 20.dp)
                        ,
                    onClick = { handleClick() }
                ) {
                    Text(
                        text = context.getString(R.string.btn_register),
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = context.getString(R.string.already_an_account),
                    color = ColorPrimary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { goToLogin()  }
                )

            }

        }

    }

}



