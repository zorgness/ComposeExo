import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ModalInfoRow(
    modifier: Modifier = Modifier,
    resId: Int,
    topInfo: String,
    bottomInfo: String,
) { Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painterResource(id = resId),
            contentDescription = null,
            modifier = Modifier
                .weight(0.2f)
                .size(20.dp)
        )

        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = topInfo,
                style = MaterialTheme.typography.h4
            )
            Text(
                text = bottomInfo,
                color = Color.Gray,
                fontSize = 12.sp
            )

        }

    }

}