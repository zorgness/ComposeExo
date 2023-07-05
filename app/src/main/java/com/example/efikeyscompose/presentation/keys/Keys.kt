package com.example.efikeyscompose.presentation.keys

import BottomNavigationComponent
import HeaderSimple
import KeyVehicleItem
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.efikeyscompose.data.dto.Vehicle
import com.example.efikeyscompose.presentation.keys.components.FilterButton
import com.example.efikeyscompose.presentation.keys.components.SearchKeys
import com.example.efikeyscompose.utils.FilterBtn
import com.example.efikeyscompose.utils.Screen

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

    val vehicleList = Vehicle.SAMPLES
    val searchStr by viewModel.searchStateFlow.collectAsState()

    KeyContent(
        navController = navController,
        searchStr = searchStr,
        filterList = filterList,
        vehicleList = vehicleList,
        handleValue = {viewModel.updateSearchStr(it)},
        handleVehicleClicked = { index ->
            navController.navigate(Screen.Modal.route + "/$index")
        }
    )
}

@Composable
fun KeyContent(
    navController: NavHostController,
    searchStr: String,
    filterList: List<FilterBtn>,
    vehicleList: List<Vehicle>,
    handleValue: (String) -> Unit,
    handleVehicleClicked: (Int) -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            HeaderSimple(
                title = "Les clés"
            )
            SearchKeys(
                value = searchStr,
                handleValue = handleValue
            )

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                contentPadding = PaddingValues(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                items(filterList) {filterBtn ->
                    FilterButton(
                        filterBtn = filterBtn,
                        isSelected = filterBtn.id == 1,
                        handleClicked = {}
                    )
                }
            }

            LazyColumn(
                modifier = Modifier.padding(bottom = 75.dp)
            ) {
                itemsIndexed(vehicleList) {index, vehicle->
                    KeyVehicleItem(
                        index = index,
                        vehicle = vehicle
                    ) { handleVehicleClicked(it) }
                }
            }
        }

        Box(
            modifier = Modifier
            .align(Alignment.BottomCenter)
        ) {
            BottomNavigationComponent(navController = navController )
        }
    }
}




/*@Preview(showBackground = true)
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
            filterList = filterList,
            vehicleList = Vehicle.SAMPLES
        )

    }
}*/

