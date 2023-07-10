package com.example.efikeyscompose.presentation.modal.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.efikeyscompose.R
import com.example.efikeyscompose.presentation.ui.theme.ColorPrimary

@Composable
fun InfoKeyAvailable(
    context: Context,
    isOpen: Boolean = false,
    inBoxId: Int? = 0,
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(horizontal = 16.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(ColorPrimary),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        if(isOpen) {
            Image(
                painterResource(id = R.drawable.userfeedback_icon),
                contentDescription = null,
                modifier = Modifier.size(28.dp).weight(0.2f)
            )
        }
        Column(
            modifier = Modifier.fillMaxHeight().weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = if(isOpen) String.format(context.getString(R.string.inbox_number_open), inBoxId)
                       else context.getString(R.string.key_is_available) ,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            if(isOpen) {
                Text(
                    text = context.getString(R.string.can_take_key),
                    color = Color.White,
                    style = MaterialTheme.typography.body2
                )
            }
        }

    }

}