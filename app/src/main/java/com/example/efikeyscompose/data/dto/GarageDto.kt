package com.example.efikeyscompose.data.dto

import android.net.Uri
import androidx.compose.ui.graphics.Color
import com.example.efikeyscompose.presentation.ui.theme.ColorAccent
import com.example.efikeyscompose.presentation.ui.theme.ColorPrimary
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
            SAMPLE.copy(id = 300, status = GarageStatusEnum.CONSTRUCTOR),
            SAMPLE.copy(id = 400, name = "Speedy Charles de Fitte"),
            SAMPLE.copy(id = 500, status = GarageStatusEnum.CONSTRUCTOR),
            SAMPLE.copy(id = 600, name = "Speedy Charles de Fitte"),
            SAMPLE.copy(id = 700, status = GarageStatusEnum.CONSTRUCTOR),
            SAMPLE.copy(id = 800, name = "Speedy Charles de Fitte"),
            SAMPLE.copy(id = 900, status = GarageStatusEnum.CONSTRUCTOR),
            SAMPLE.copy(id = 1000, name = "Speedy Charles de Fitte"),
            SAMPLE.copy(id = 1100, status = GarageStatusEnum.CONSTRUCTOR)
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

data class GarageStatus(
    val title: String,
    val color: Color
) {
    companion object {
        val independant: GarageStatus = GarageStatus(
            title = "Garage indépendant",
            color = ColorAccent
        )
        val constructor: GarageStatus = GarageStatus(
            title = "Garage constructeur",
            color = ColorPrimary
        )
    }
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
            listOf("https://www.automobile-magazine.fr/asset/cms/178540/config/127282/cooper.jpg",
                "https://www.largus.fr/images/images/2005-mini-one-cabriolet-01.jpg",
            "https://agenceauto.com/upload/image/large/133023-20230330045521-6425a2d98e8d0IMG_20230329_175958.jpg"),
            4240,
            "Pierre Dupont",
            "06 22 12 09 14",
            KeyStatusEnum.AVAILABLE,
            null,
            BoxStatusEnum.INBOX,
        )

        val SAMPLE2: Vehicle = Vehicle(
            "GL-559-MM",
            "Mercedes Classe A 4",
            listOf("https://cdn.drivek.com/configurator-imgs/cars/fr/original/MERCEDES/A-CLASS/41348_HATCHBACK-5-DOORS/mercedes-benz-classe-a-hb-front-view.jpg",
                "https://images.caradisiac.com/images/0/7/1/2/200712/S1-essai-video-mercedes-classe-a-restylee-2023-une-etoile-plus-brillante-745771.jpg",
                "https://cdn.motor1.com/images/mgl/3WQGM6/s3/mercedes-benz-a-klasse-2023.jpg"),
            12400,
            "Martin Durand",
            "06 72 83 09 19",
            KeyStatusEnum.AVAILABLE,
            null,
            BoxStatusEnum.INBOX,
        )

        val SAMPLES: List<Vehicle> = listOf(
            SAMPLE,
            SAMPLE2,
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
