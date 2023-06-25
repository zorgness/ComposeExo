package com.example.efikeyscompose.data.dto

import android.net.Uri
import java.util.*

data class Garage(
    val id: Long,
    val name: String,
    val status: GarageStatusEnum,
    val imageUrl: String,
) {
    companion object {
        val SAMPLE: Garage = Garage(
            100,
            "Speedy Charles de Fitte",
            GarageStatusEnum.INDEPENDENT,
            "https://www.auto-infos.fr/mediatheque/4/4/8/000089844_600x400_c.jpg"
        )

        val SAMPLES: List<Garage> = listOf(
            SAMPLE,
            SAMPLE.copy(id = 200, name = "Speedy Charles de Fitte"),
            SAMPLE.copy(id = 300, status = GarageStatusEnum.CONSTRUCTOR)
        )
    }
}

data class SelectableGarage(
    val garage: Garage,
    val isSelected: Boolean
)


enum class GarageStatusEnum {
    INDEPENDENT,
    CONSTRUCTOR,
}

data class Vehicle(
    val licensePlate: String,
    val type: String,
    val imageUrls: List<String> = emptyList(),
    val kilometer: Int,
    val contactName: String,
    val contactPhone: String,
    val keyStatus: KeyStatusEnum,
    val collectedBy: String?,
    val boxStatus: BoxStatusEnum,
) {
    companion object {
        val SAMPLE: Vehicle = Vehicle(
            "AB-123-CD",
            "Mini Cooper Essence",
            listOf("https://www.automobile-magazine.fr/asset/cms/178540/config/127282/cooper.jpg"),
            4240,
            "Pierre Dupont",
            "06 22 12 09 14",
            KeyStatusEnum.AVAILABLE,
            null,
            BoxStatusEnum.INBOX,
        )

        val SAMPLES: List<Vehicle> = listOf(
            SAMPLE,
            SAMPLE.copy(
                keyStatus = KeyStatusEnum.COLLECTED,
                collectedBy = "Eric G.",
                boxStatus = BoxStatusEnum.USED
            ),
            SAMPLE,
        )
    }
}

enum class KeyStatusEnum {
    AVAILABLE,
    COLLECTED,
}

enum class BoxStatusEnum {
    INBOX,
    INBOX_DOCK,
    USED
}

sealed class AddVehicleItem {
    object CameraCard : AddVehicleItem()
    data class CarCard(
        val id: String ? = UUID.randomUUID().toString(),
        val imageUri: Uri
    ) : AddVehicleItem()
}
