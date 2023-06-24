import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.mycomposeskeleton.R
import com.example.mycomposeskeleton.presentation.auth.login.LoginViewModel
import com.example.mycomposeskeleton.presentation.ui.theme.ColorPrimary
import com.example.mycomposeskeleton.presentation.ui.theme.EfiKeysComposeTheme
import com.example.mycomposeskeleton.utils.Screen

@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel
) {
    val email by viewModel.emailStateFlow.collectAsState("")
    val password by viewModel.passwordStateFlow.collectAsState("")

    val context = LocalContext.current

    LaunchedEffect(true) {
        viewModel.goToMainSharedFlow.collect {
            navController.navigate(it.route) {
                popUpTo(Screen.Login.route) {
                    inclusive = true
                }
            }
        }
    }

    LaunchedEffect(true ) {
        viewModel.loginStateSharedFlow.collect {state->
            when(state) {
                LoginViewModel.LoginState.ERROR_SERVER -> R.string.error_server
                LoginViewModel.LoginState.ERROR_CONNECTION -> R.string.error_connection
                LoginViewModel.LoginState.WRONG_CREDENTIAL -> R.string.wrong_credentials
                LoginViewModel.LoginState.EMPTY_FIELDS -> R.string.empty_fields
                LoginViewModel.LoginState.SECURITY_FAILURE -> R.string.security_failure
                LoginViewModel.LoginState.ERROR_PARAM -> R.string.error_param
                LoginViewModel.LoginState.ERROR_SERVICE -> R.string.error_service
                LoginViewModel.LoginState.SUCCESS -> R.string.login_success
            }.let {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        }
    }

    LoginContent(
        context = context,
        email = email,
        password = password,
        handleEmail = { viewModel.updateEmail(it) },
        handlePassword = { viewModel.updatePassword(it) },
        handleClick = { viewModel.login() },
        goToRegister = {
            navController.navigate(Screen.Register.route)
        }
    )
}

@Composable
fun LoginContent(
    context: Context,
    email: String,
    password: String,
    handleEmail: (String) -> Unit,
    handlePassword: (String) -> Unit,
    handleClick: () -> Unit,
    goToRegister: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.efikeys_logo) ,
            contentDescription = null,
            modifier = Modifier.padding(top= 10.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = context.getString(R.string.connect),
            style = MaterialTheme.typography.h2,

        )
        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier.fillMaxHeight()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.TopCenter),

                ) {
                CustomTextField(
                    placeholder = context.getString(R.string.email),
                    value = email,
                    handleValue = { handleEmail(it) }
                )
                Spacer(modifier = Modifier.height(40.dp))
                CustomTextField(
                    placeholder = context.getString(R.string.password),
                    value = password,
                    isPassword = true,
                    handleValue = { handlePassword(it) }
                )
                Box(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = context.getString(R.string.forget_password),
                        modifier = Modifier
                            .padding(top= 10.dp)
                            .align(Alignment.CenterEnd),
                        textDecoration = TextDecoration.Underline,
                        fontSize = 12.sp,
                    )
                }

            }


            Column(
                modifier = Modifier
                    .padding(bottom = 120.dp)
                    .align(Alignment.BottomCenter),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .padding(horizontal = 20.dp),
                    onClick = { handleClick() }
                ) {
                    Text(
                        text = context.getString(R.string.connect),
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = context.getString(R.string.no_account_yet),
                    color = ColorPrimary,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { goToRegister() }
                )
            }

        }


    }
}

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EfiKeysComposeTheme {
        LoginContent(
            context = LocalContext.current ,
            email ="" ,
            password = "",
            handleEmail = {} ,
            handlePassword = {},
            handleClick = {  }) {
            
        }
    }
}*/
