package com.example.efikeyscompose.presentation.keys.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.efikeyscompose.presentation.ui.theme.ColorAccent
import com.example.efikeyscompose.presentation.ui.theme.ColorPrimary
import com.example.efikeyscompose.utils.FilterBtn

@Composable
fun FilterButton(
    filterBtn: FilterBtn,
    isSelected: Boolean = false,
    handleClicked: (Int) -> Unit

){

    Button(
        modifier = Modifier.padding(end= 4.dp),
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if(isSelected) ColorAccent else Color.LightGray,
            contentColor = if(isSelected) ColorPrimary else Color.DarkGray
        ),
        onClick = {handleClicked(filterBtn.id) }
    ) {
        Text(
            text= filterBtn.name,
            fontWeight = FontWeight.SemiBold,
        )
    }

}