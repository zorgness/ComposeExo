import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.efikeyscompose.R
import com.example.efikeyscompose.data.dto.Garage
import com.example.efikeyscompose.data.dto.GarageStatus
import com.example.efikeyscompose.data.dto.GarageStatusEnum
import com.example.efikeyscompose.data.dto.SelectableGarage
import com.example.efikeyscompose.presentation.site.SiteScreen
import com.example.efikeyscompose.presentation.ui.theme.ColorAccent
import com.example.efikeyscompose.presentation.ui.theme.ColorPrimary
import com.example.efikeyscompose.presentation.ui.theme.EfiKeysComposeTheme

@Composable
fun SiteItem (
    garage: Garage,
    selectedId: Long,
    handleSelected: (Long) -> Unit
) {

    val (status, color) = getGarageStatus(garage.status)
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            RadioButton(
                selected = selectedId == garage.id,
                onClick = {
                    handleSelected(garage.id)
                },
                modifier = Modifier.weight(0.2f)
            )
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(
                        shape = RoundedCornerShape(8.dp)
                    )
                    .background(color)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.car_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = garage.name,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(start = 20.dp )
                )

                Text(
                    text = status,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(start = 20.dp )
                )

            }
        }
    }
}

fun getGarageStatus(status: GarageStatusEnum): GarageStatus =
    when(status) {
        GarageStatusEnum.INDEPENDENT -> {
            GarageStatus.independant
        }
        GarageStatusEnum.CONSTRUCTOR -> {
            GarageStatus.constructor
        }
    }


