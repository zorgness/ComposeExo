package com.example.efikeyscompose.presentation.add_vehicle.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.efikeyscompose.R
import com.example.efikeyscompose.presentation.ui.theme.ColorAccent

@Composable
fun CameraCardItem(
    handleClick: () -> Unit
) {
        Box(
            modifier = Modifier
                .width(180.dp)
                .height(140.dp)
        ) {
            Column(
                modifier = Modifier
                    .width(160.dp)
                    .height(100.dp)
                    .background(ColorAccent)
                    .align(Alignment.Center)
                    .clickable { handleClick() },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                Image(
                    painter = painterResource(id = R.drawable.camera_icon) ,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
                Text(
                    text = "Ajouter",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

            }


        }
}

