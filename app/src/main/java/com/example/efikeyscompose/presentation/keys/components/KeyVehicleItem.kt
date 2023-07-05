import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.efikeyscompose.data.dto.Vehicle
import com.example.efikeyscompose.presentation.ui.theme.ColorAccent
import com.example.efikeyscompose.presentation.ui.theme.ColorMainOrange
import com.example.efikeyscompose.presentation.ui.theme.ColorPrimary
import com.example.efikeyscompose.utils.isAvailable

@Composable
fun KeyVehicleItem(
    index: Int,
    vehicle: Vehicle,
    handleClicked: (Int) -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(172.dp)
            .padding(horizontal = 10.dp, vertical = 6.dp)
            .clickable { handleClicked(index) },
        shape = RoundedCornerShape(12.dp),
        elevation = 4.dp
    ) {

        Box () {
            Row(
                modifier = Modifier
                    .align(Alignment.TopCenter),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .height(140.dp)
                        .weight(1f)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = vehicle.licensePlate,
                        style = MaterialTheme.typography.h4,
                        color = ColorPrimary,
                    )
                    Column {
                        Text(
                            text = vehicle.type,
                            style = MaterialTheme.typography.body2,
                            color = ColorPrimary,
                        )
                        Text(
                            text = "${ vehicle.kilometer} km",
                            style = MaterialTheme.typography.body2,
                            color = Color.DarkGray
                        )
                    }
                    Column {
                        Text(
                            text = vehicle.contactName,
                            style = MaterialTheme.typography.body2,
                            color = ColorPrimary,
                        )
                        Text(
                            text = vehicle.contactPhone,
                            style = MaterialTheme.typography.body2,
                            color = Color.DarkGray
                        )
                    }

                }

                AsyncImage(
                    modifier = Modifier.weight(1f),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(vehicle.imageUrls[0])
                        .crossfade(true)
                        .build(),
                    contentDescription = vehicle.type)

            }

            Text(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .background(
                        if(isAvailable(vehicle.keyStatus)) ColorAccent
                        else ColorMainOrange
                    ),
                text =  if(isAvailable(vehicle.keyStatus)) "Clé disponible"
                        else "Clé récupéré par ${vehicle.collectedBy}",
                textAlign = TextAlign.Center,
                color = Color.White
            )

        }
    }
}


/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EfiKeysComposeTheme {

        KeyVehicleItem(vehicle = Vehicle.SAMPLE)
    }
}*/
