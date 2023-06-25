package com.example.efikeyscompose.presentation.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.efikeyscompose.data.dto.Vehicle
import com.example.efikeyscompose.presentation.ui.theme.ColorPrimary

@Composable
fun HomeVehicleItem(
    vehicle: Vehicle
) {

    Card(
        modifier = Modifier
        .fillMaxWidth()
        .height(148.dp)
        .padding(horizontal = 10.dp, vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = 4.dp
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.7f)
                    .padding(10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = vehicle.licensePlate,
                    style = MaterialTheme.typography.h4,
                    color = ColorPrimary,

                )
                Text(
                    text = vehicle.type,
                    style = MaterialTheme.typography.body2,
                    color = ColorPrimary,
                )
            }

            AsyncImage(
                modifier = Modifier.weight(1f),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(vehicle.imageUrls[0])
                    .crossfade(true)
                    .build(),
                contentDescription = vehicle.type)

        }
    }
}


