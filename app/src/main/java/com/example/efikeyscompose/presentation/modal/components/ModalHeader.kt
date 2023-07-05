package com.example.efikeyscompose.presentation.modal.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.efikeyscompose.R
import com.example.efikeyscompose.presentation.ui.theme.ColorAccent
import com.example.efikeyscompose.presentation.ui.theme.ColorMainOrange

@Composable
fun ModalHeader(
    licencePlate: String,
    type: String,
    isOpen: Boolean = false,
    handleNavBack: () -> Unit

) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(if(isOpen) ColorAccent else ColorMainOrange)
        ) {

            Image(
                painterResource(id = if(isOpen) R.drawable.unlock_icon else R.drawable.lock_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.Center)
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = licencePlate,
                style = MaterialTheme.typography.h4
            )

            Text(
                text = type,
                style = MaterialTheme.typography.body2,
                color = Color.Gray
            )
        }

        Image(
            painterResource(
                id = R.drawable.modalcross_icon
            ),
            modifier = Modifier
                .size(28.dp)
                .clickable { handleNavBack() },
            contentDescription = null,
        )

    }

}