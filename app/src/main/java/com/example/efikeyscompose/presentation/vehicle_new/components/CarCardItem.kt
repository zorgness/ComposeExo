package com.example.efikeyscompose.presentation.vehicle_new.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.efikeyscompose.R
import com.example.efikeyscompose.data.dto.AddVehicleItem
import com.example.efikeyscompose.presentation.ui.theme.ColorAccent


@Composable
fun CarCardItem(
    item: AddVehicleItem.CarCard,
    position: Int,
    handleClick: (AddVehicleItem.CarCard) -> Unit
) {

    Box(
        modifier = Modifier
            .width(180.dp)
            .height(140.dp)
    ) {
        Box(
            modifier = Modifier
                .width(160.dp)
                .height(100.dp)
                .align(Alignment.Center)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.imageUri)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(
                    color = Color.Black.copy(alpha = 0.3f),
                    blendMode = BlendMode.Darken

                )
            )
        }

        Image(
            painter = painterResource(id = R.drawable.vehiclecross_icon),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 8.dp, end = 8.dp)
                .clip(shape = CircleShape)
                .background(Color.White)
                .size(20.dp).clickable {
                    handleClick(item)
                }
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 8.dp, end = 8.dp)
                .size(20.dp)
                .clip(shape = RoundedCornerShape(2.dp))
                .background(ColorAccent)

        ) {
            Text(
                text = position.toString(),
                color = Color.White,
                fontSize= 10.sp,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }

    }
}
