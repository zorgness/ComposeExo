package com.example.efikeyscompose.presentation.vehicle_new

import CustomTextField
import CustomTextFieldKilometers
import HeaderCommon
import android.content.Context
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.efikeyscompose.R
import com.example.efikeyscompose.data.dto.AddVehicleItem
import com.example.efikeyscompose.presentation.vehicle_new.components.CameraCardItem
import com.example.efikeyscompose.presentation.vehicle_new.components.CarCardItem
import com.example.efikeyscompose.presentation.ui.theme.EfiKeysComposeTheme

@Composable
fun VehicleNewScreen(
    navController: NavHostController,
    viewModel: VehicleNewViewModel
) {

    val context = LocalContext.current
    val license by viewModel.licenceStateFlow.collectAsState()
    val kilometers by viewModel.kilometersStateFlow.collectAsState()

    val list by viewModel.itemListStateFlow.collectAsState()

    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { it?.let {
                viewModel.addToList(
                    AddVehicleItem.CarCard(imageUri = it)
                )
            }
        }
    )


    VehicleNewContent(
        context = context,
        license = license,
        kilometers = kilometers,
        list = list,
        handleLicense = { viewModel.updateLicense(it) },
        handleKilometers = { viewModel.updateKilometers(it) },
        handleNavBack = { navController.popBackStack() },
        handleGallery = {
            singlePhotoPickerLauncher.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
            )
        },
        handleRemoveItem = { viewModel.removeItem(it) },
    )

}
@Composable
fun VehicleNewContent(
    context: Context,
    license: String,
    kilometers: Long,
    list: List<AddVehicleItem>,
    handleLicense: (String) -> Unit,
    handleKilometers: (Long) -> Unit,
    handleNavBack: () -> Unit,
    handleGallery: () -> Unit,
    handleRemoveItem: (AddVehicleItem.CarCard) -> Unit
) {
    
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        HeaderCommon(
            title = context.getString(R.string.add_vehicle)
        ) {
            handleNavBack()
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            CustomTextField(
                placeholder = context.getString(R.string.lincense),
                value = license,
                handleValue = { handleLicense(it) }
            )
            Spacer(modifier = Modifier.height(40.dp))
            CustomTextFieldKilometers(
                placeholder = context.getString(R.string.kilometers_vehicle),
                value = if(kilometers == 0L) "" else kilometers.toString(),
                // TODO find a better way
                handleValue = { handleKilometers(it.toLongOrNull() ?: 0L) }
            )

        }

        Box(
            modifier = Modifier.fillMaxHeight()
        ) {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(bottom = 100.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(16.dp),
                content = {

                    items(list.size) { index ->

                        when(list[index]) {
                            is AddVehicleItem.CameraCard -> {
                                CameraCardItem {
                                    handleGallery()
                                }
                            }
                            is AddVehicleItem.CarCard -> {
                                CarCardItem(
                                    position = index,
                                    item = list[index] as AddVehicleItem.CarCard
                                ) {
                                    handleRemoveItem(it)
                                }
                            }
                        }
                    }
                }
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 40.dp)
                    .background(Color.White)
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .padding(horizontal = 20.dp),
                    onClick = { }
                ) {
                    Text(
                        text = context.getString(R.string.done),
                        color = Color.White
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EfiKeysComposeTheme {
      VehicleNewContent(
          context = LocalContext.current,
          license = "",
          kilometers = 0,
          list = emptyList(),
          handleKilometers = {},
          handleLicense = {},
          handleNavBack = {},
          handleGallery = {},
          handleRemoveItem = {}
      )
    }
}