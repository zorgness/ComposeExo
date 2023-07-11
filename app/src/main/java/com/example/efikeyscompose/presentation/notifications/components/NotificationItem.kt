package com.example.efikeyscompose.presentation.notifications.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NotificationItem(
    resId: Int,
    topInfo: String,
    bottomInfo: String
) {
    Card(
        modifier = Modifier.height(48.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painterResource(id = resId),
                contentDescription = null,
                modifier = Modifier
                    .weight(0.2f)
                    .size(20.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = topInfo,
                    style = MaterialTheme.typography.h4
                )
                Text(
                    text = bottomInfo,
                    color = Color.Gray,
                    fontSize = 12.sp
                )

            }

        }


    }
}
