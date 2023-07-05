package com.example.efikeyscompose.utils

import com.example.efikeyscompose.data.dto.BoxStatusEnum
import com.example.efikeyscompose.data.dto.KeyStatusEnum

fun isAvailable(status: KeyStatusEnum) =
    when (status) {
        KeyStatusEnum.AVAILABLE -> true
        KeyStatusEnum.COLLECTED -> false
    }

fun isInBox(status: BoxStatusEnum) =
    when(status) {
        BoxStatusEnum.INBOX -> true
        BoxStatusEnum.USED -> false
        BoxStatusEnum.INBOX_DOCK -> TODO()
    }