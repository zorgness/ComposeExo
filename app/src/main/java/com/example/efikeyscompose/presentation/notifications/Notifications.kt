package com.example.efikeyscompose.presentation.notifications

import HeaderCommon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.efikeyscompose.R
import com.example.efikeyscompose.presentation.notifications.components.NotificationItem
import com.example.efikeyscompose.presentation.ui.theme.EfiKeysComposeTheme

@Composable
fun NotificationsScreen(
    navController: NavHostController
) {
    NotificationContent {
        navController.popBackStack()
    }
}

@Composable
fun NotificationContent(
    handleNavBack:() -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderCommon(title = "Notifications") {
            handleNavBack()
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            NotificationItem(
                resId = R.drawable.profil_icon,
                topInfo = "Eric Gru souhaite récupérer une clé",
                bottomInfo = "CP-911-WR/ BMW X3 Break Diesel"
            )
            NotificationItem(
                resId = R.drawable.profil_icon,
                topInfo = "Eric Gru souhaite récupérer une clé",
                bottomInfo = "CP-911-WR/ BMW X3 Break Diesel"
            )
        }

    }
}


/*@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EfiKeysComposeTheme {
       NotificationContent()
    }
}*/
