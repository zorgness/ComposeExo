package com.example.efikeyscompose.presentation.modal.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DotsIndicator(
    modifier: Modifier = Modifier,
    totalDots: Int,
    selectedIndex: Int,
    selectedColor: Color = Color.White,
    unSelectedColor: Color = Color.Gray,
    dotSize: Dp
) {
        LazyRow(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
        ) {
            items(totalDots) {index ->
                IndicatorDot(
                    size = dotSize,
                    color = if(index == selectedIndex) selectedColor else unSelectedColor
                )
                
                if(index != totalDots - 1) {
                    Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                }
            }
        }

}