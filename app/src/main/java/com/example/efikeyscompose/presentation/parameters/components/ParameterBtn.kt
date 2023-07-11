package com.example.efikeyscompose.presentation.parameters.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.efikeyscompose.R
import com.example.efikeyscompose.presentation.ui.theme.EfiKeysComposeTheme

@Composable
fun ParameterBtn(
    name: String,
    resId: Int
) {

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(8.dp),
        onClick = { /*TODO*/ }
    ) {
       Box(
           modifier = Modifier.fillMaxWidth(),
       ) {
           Icon(
               modifier = Modifier
                   .align(Alignment.CenterStart)
                   .padding(start = 20.dp)
                   .size(20.dp),
               painter = painterResource(id = resId),
               contentDescription = name
           )

           Text(
               modifier = Modifier.align(Alignment.Center),
               text = name,
               fontWeight = FontWeight.Bold
           )
       }
    }
}
/*

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EfiKeysComposeTheme {
        ParameterBtn(
            name = "Centre d'assistance",
            resId = R.drawable.assistancecenter_icon
        )

    }
}*/
