package com.example.efikeyscompose.presentation.keys.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.efikeyscompose.presentation.ui.theme.SearchBarColor

@Composable
fun SearchBarKeys (
    value: String,
    handleValue: (String) -> Unit
) {
    TextField(
        value = value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = null,
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp),
                tint = Color.Black
            )
        },
        placeholder = {
            Text(
                text= "Entrez l'une des caractéristiques du...",
                fontSize = 12.sp
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = SearchBarColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        onValueChange = { handleValue(it) }
    )


}