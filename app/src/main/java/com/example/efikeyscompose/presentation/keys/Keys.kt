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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.efikeyscompose.data.dto.Vehicle
import com.example.efikeyscompose.presentation.keys.components.FilterButton
import com.example.efikeyscompose.presentation.keys.components.SearchBarKeys
import com.example.efikeyscompose.utils.FilterBtn
import com.example.efikeyscompose.utils.Screen
import com.example.efikeyscompose.R
import com.example.efikeyscompose.data.dto.BoxStatusEnum

@Composable
fun KeyScreen(
    navController: NavHostController,
    viewModel: KeyViewModel
) {

    val filterBtnList = listOf(
        FilterBtn(1, "Toutes"),
        FilterBtn(2, "Inbox Dock", BoxStatusEnum.INBOX_DOCK),
        FilterBtn(3, "Inbox", BoxStatusEnum.INBOX),
        FilterBtn(4, "Utilisées", BoxStatusEnum.USED)
    )

    val vehicleList by viewModel.vehicleListStateFlow.collectAsState()
    val searchStr by viewModel.searchStateFlow.collectAsState()
    val btnSelected by viewModel.btnSelectedStateFlow.collectAsState()

    KeyContent(
        navController = navController,
        searchStr = searchStr,
        filterBtnList = filterBtnList,
        vehicleList = vehicleList,
        btnSelected = btnSelected,
        handleValue = { viewModel.updateSearchStr(it) },
        handleVehicleClicked = { vehicleId ->
            navController.navigate(Screen.Modal.route + "/$vehicleId")
        },
        handleFilterBtnClicked = { viewModel.updateBtnSelected(it)
        }
    )
}

@Composable
fun KeyContent(
    navController: NavHostController,
    searchStr: String,
    filterBtnList: List<FilterBtn>,
    vehicleList: List<Vehicle>,
    btnSelected: FilterBtn,
    handleValue: (String) -> Unit,
    handleVehicleClicked: (String) -> Unit,
    handleFilterBtnClicked: (FilterBtn) -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            HeaderSimple(
                title = LocalContext.current.getString(R.string.keys)
            )
            SearchBarKeys(
                value = searchStr,
                handleValue = handleValue
            )

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                contentPadding = PaddingValues(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                items(filterBtnList) { filterBtn ->
                    FilterButton(
                        filterBtn = filterBtn,
                        isSelected = filterBtn == btnSelected
                    ) {
                        handleFilterBtnClicked(filterBtn)
                    }
                }
            }

            LazyColumn(
                modifier = Modifier.padding(bottom = 75.dp)
            ) {
                itemsIndexed(vehicleList) { index, vehicle ->
                    KeyVehicleItem(
                        index = index,
                        vehicle = vehicle
                    ) { handleVehicleClicked(vehicle.id) }
                }
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
        ) {
            BottomNavigationComponent(navController = navController)
        }
    }
}

