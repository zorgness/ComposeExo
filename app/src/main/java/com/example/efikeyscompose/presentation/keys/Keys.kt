package com.example.efikeyscompose.presentation.keys

import BottomNavigationScreen
import HeaderKeys
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Looks
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Looks
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.efikeyscompose.data.dto.Garage
import com.example.efikeyscompose.presentation.keys.components.FilterButton
import com.example.efikeyscompose.presentation.keys.components.SearchKeys
import com.example.efikeyscompose.presentation.site.SiteContent
import com.example.efikeyscompose.presentation.ui.theme.EfiKeysComposeTheme
import com.example.efikeyscompose.presentation.ui.theme.SearchBarColor
import com.example.efikeyscompose.utils.FilterBtn

@Composable
fun KeyScreen(
    navController: NavHostController,
    viewModel: KeyViewModel
) {

    val filterList = listOf(
        FilterBtn(1,"Toutes"),
        FilterBtn(2,"Inbox Dock"),
        FilterBtn(3,"Inbox"),
        FilterBtn(4,"Utilisées")
    )

    val searchStr by viewModel.searchStateFlow.collectAsState()
    KeyContent(
        //navController = navController,
        filterList = filterList
    )
}

@Composable
fun KeyContent(
    //navController: NavHostController,
    filterList: List<FilterBtn>
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            HeaderKeys()
            SearchKeys()

            Row(
                modifier = Modifier.fillMaxWidth().padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                filterList.forEach {filterBtn ->
                    FilterButton(
                        filterBtn = filterBtn,
                        isSelected = filterBtn.id == 1,
                        handleClicked = {}
                    )
                }
            }
        }




        Box(
            modifier = Modifier
            .align(Alignment.BottomCenter)
        ) {
            //BottomNavigationScreen(navController = navController )
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EfiKeysComposeTheme {
        val filterList = listOf(
            FilterBtn(1,"Toutes"),
            FilterBtn(2,"Inbox Dock"),
            FilterBtn(3,"Inbox"),
            FilterBtn(4,"Utilisées")
        )
        KeyContent(
            filterList = filterList
        )

    }
}

