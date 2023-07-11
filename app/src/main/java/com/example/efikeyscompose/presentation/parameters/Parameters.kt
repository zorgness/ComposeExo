package com.example.efikeyscompose.presentation.parameters

import HeaderCommon
import com.example.efikeyscompose.presentation.parameters.components.ParameterBtn
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.efikeyscompose.R
import com.example.efikeyscompose.presentation.ui.theme.EfiKeysComposeTheme

@Composable
fun ParametersScreen(
    navController: NavHostController
) {
    ParametersContent(
        handleNavBack = { navController.popBackStack() }
    )
}

@Composable
fun ParametersContent(
    handleNavBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HeaderCommon(title = "Paramètres") {
            handleNavBack()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(top = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Langue"
            )
            Row {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://upload.wikimedia.org/wikipedia/commons/thumb/b/bc/Flag_of_France_%281794%E2%80%931815%2C_1830%E2%80%931974%2C_2020%E2%80%93present%29.svg/langfr-225px-Flag_of_France_%281794%E2%80%931815%2C_1830%E2%80%931974%2C_2020%E2%80%93present%29.svg.png")
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(28.dp)
                        .width(40.dp)
                        .padding(end = 8.dp)
                )
                Icon(
                    Icons.Outlined.ExpandMore,
                    contentDescription = null,
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .padding(horizontal = 20.dp)
                .padding(top= 40.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            ParameterBtn(
                name = "Centre d'assistance" ,
                resId = R.drawable.assistancecenter_icon
            )
            ParameterBtn(
                name = "Support par email" ,
                resId = R.drawable.mail_icon
            )
            ParameterBtn(
                name = "Support téléphonique" ,
                resId = R.drawable.phone_icon
            )
            ParameterBtn(
                name = "Retour utilisateurs" ,
                resId = R.drawable.userfeedback_icon
            )
            
        }

    }
}



