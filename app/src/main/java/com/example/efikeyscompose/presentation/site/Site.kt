package com.example.efikeyscompose.presentation.site

import SiteItem
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.efikeyscompose.R
import com.example.efikeyscompose.data.dto.Garage
import com.example.efikeyscompose.presentation.ui.theme.ColorPrimary
import com.example.efikeyscompose.presentation.ui.theme.EfiKeysComposeTheme
import com.example.efikeyscompose.shared_viewmodel.HomeAndSiteViewModel
import com.example.efikeyscompose.utils.Screen

@Composable
fun SiteScreen(
    navController: NavHostController,
    viewModel: HomeAndSiteViewModel
) {
    val context = LocalContext.current

    val selectedGarage by viewModel.selectedGarageStateFlow.collectAsState()

    SiteContent(
        context = context,
        siteList = Garage.SAMPLES,
        selectedGarage = selectedGarage,
        handleClick = {
            navController.navigate(Screen.Home.route)
        },
        handleSelected = { viewModel.updateSelectedGarage(it) }
    )
}

@Composable
fun SiteContent(
    context: Context,
    siteList: List<Garage>,
    selectedGarage: Garage,
    handleClick:() -> Unit,
    handleSelected:(Garage) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(16.dp)
        ) {
            Text(
                text = context.getString(R.string.site_activity),
                style = MaterialTheme.typography.h2
            )
            Text(
                text = context.getString(R.string.select_site_activity),
                style = MaterialTheme.typography.h4,
                color = ColorPrimary,
                modifier = Modifier.padding(top= 12.dp)
            )

            LazyColumn(
                modifier = Modifier
                    .padding(
                        top = 40.dp,
                        bottom = 80.dp
                    )
            ) {
                items(siteList) {site ->
                    SiteItem(
                        site,
                        selectedGarage = selectedGarage
                    )
                    { handleSelected(it) }
                }
            }
        }


        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 40.dp)
                .background(Color.White)
        ) {
            Button(
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                onClick = { handleClick() }
            ) {
                Text(
                    text= context.getString(R.string.confirm),
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EfiKeysComposeTheme {
        SiteContent(
            context = LocalContext.current,
            siteList = Garage.SAMPLES,
            selectedGarage = Garage.SAMPLE,
            handleClick = {},
            handleSelected = {}
        )
    }
}