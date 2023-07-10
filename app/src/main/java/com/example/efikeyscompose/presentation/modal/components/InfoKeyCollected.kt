import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.efikeyscompose.R
import com.example.efikeyscompose.presentation.ui.theme.ColorPrimary

@Composable
fun InfoKeyCollected(collectedBy: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(horizontal = 16.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(ColorPrimary),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {

            Image(
                painterResource(id = R.drawable.userfeedback_icon),
                contentDescription = null,
                modifier = Modifier.size(28.dp).weight(0.2f)
            )

        Column(
            modifier = Modifier.fillMaxHeight().weight(1f),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "Clé en possession de $collectedBy",
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
            Text(
                text =  "depuis le 00/00/00" ,
                color = Color.White,
                style = MaterialTheme.typography.body2
            )

        }

    }

}