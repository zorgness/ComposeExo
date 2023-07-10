package com.example.efikeyscompose.utils

import com.example.efikeyscompose.data.dto.BoxStatusEnum

data class FilterBtn(
    val id: Int,
    val name: String,
    val boxStatus: BoxStatusEnum? = null
)
