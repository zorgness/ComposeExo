package com.example.efikeyscompose.presentation.modal

import InfoKeyCollected
import ModalInfoRow
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.efikeyscompose.R
import com.example.efikeyscompose.data.dto.KeyStatusEnum
import com.example.efikeyscompose.data.dto.Vehicle
import com.example.efikeyscompose.presentation.modal.components.Carousel
import com.example.efikeyscompose.presentation.modal.components.InfoKeyAvailable
import com.example.efikeyscompose.presentation.modal.components.ModalHeader
import com.example.efikeyscompose.presentation.ui.theme.ColorAccent
import com.example.efikeyscompose.presentation.ui.theme.ColorMainOrange
import com.example.efikeyscompose.presentation.ui.theme.ColorPrimary
import com.example.efikeyscompose.presentation.ui.theme.EfiKeysComposeTheme
import com.google.accompanist.pager.ExperimentalPagerApi

@Composable
fun ModalScreen(
    navController: NavHostController,
    vehicleId: Int,
    viewModel: ModalViewModel

) {
    val vehicle by viewModel.vehicleStateFlow.collectAsState()
    val context = LocalContext.current

    var isOpen by remember { mutableStateOf(false) }

    LaunchedEffect(true) {
        //TEMPORARY
        viewModel.getVehicleByIndedx(vehicleId)
    }

    ModalContent(
        context = context,
        vehicle = vehicle,
        isOpen = isOpen,
        handleNavBack = { navController.popBackStack() },
        setIsOpen = { isOpen = !isOpen }
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ModalContent(
    context: Context,
    vehicle: Vehicle,
    isOpen: Boolean,
    handleNavBack:() -> Unit,
    setIsOpen: () -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {

            // HEADER
            ModalHeader(
                licencePlate = vehicle.licensePlate,
                type = vehicle.type,
                isOpen = isOpen
            ) {
                handleNavBack()
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 70.dp)
        ) {
            //CAROUSEL
            Carousel(itemsCount = vehicle.imageUrls.size) { index ->
                AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                    .data(vehicle.imageUrls[index])
                    .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(200.dp))
            }

            //INFO
            Column(
                modifier = Modifier.padding(20.dp)

            ) {
                Card(
                    elevation = 8.dp,
                    modifier = Modifier
                        .padding(bottom = 20.dp)
                        .height(60.dp)
                ) {
                    ModalInfoRow(
                        modifier = Modifier,
                        resId = R.drawable.profil_icon,
                        topInfo = vehicle.contactName ,
                        bottomInfo = vehicle.contactPhone
                    )
                }
                Card(
                    elevation = 8.dp,
                    modifier = Modifier
                        .height(180.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(vertical = 10.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {

                        ModalInfoRow(
                            resId = R.drawable.vehiclecar_icon,
                            topInfo = vehicle.type ,
                            bottomInfo = "${vehicle.kilometer} km"
                        )
                        ModalInfoRow(
                            resId = R.drawable.chassisnumber_icon,
                            topInfo = context.getString(R.string.frame_number),
                            bottomInfo = "VFSIV2009ASIV2009"
                        )
                        ModalInfoRow(
                            resId = R.drawable.userinfo_icon,
                            topInfo = context.getString(R.string.user_info),
                            bottomInfo = "Problème de freins"
                        )
                    }
                }
            }

            when(vehicle.keyStatus) {
                KeyStatusEnum.AVAILABLE -> {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(64.dp)
                            .padding(horizontal = 32.dp)
                            .padding(bottom = 16.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = if(isOpen) ColorMainOrange else ColorAccent,
                            contentColor = Color.White
                        ),

                        onClick = { setIsOpen() },
                    ) {
                        Text(
                            text = if(isOpen) "Fermer le casier" else "Ouvrir le casier",
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    InfoKeyAvailable(isOpen = isOpen)

                }
                KeyStatusEnum.COLLECTED -> {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(64.dp)
                            .padding(horizontal = 32.dp)
                            .padding(bottom = 16.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor =  ColorMainOrange,
                            contentColor = Color.White
                        ),

                        onClick = { },
                    ) {
                        Text(
                            text = "Demander la clé",
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    InfoKeyCollected(vehicle.collectedBy ?: "")
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EfiKeysComposeTheme {

        ModalContent(
            context = LocalContext.current,
            isOpen = true,
            vehicle = Vehicle.SAMPLE,
            setIsOpen = {},
            handleNavBack = {}
        )



    }
}