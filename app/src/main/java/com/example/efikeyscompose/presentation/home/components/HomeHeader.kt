import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.efikeyscompose.R

@Composable
fun HomeHeader(
    onLogoutIconClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
    ) {
        Text(
            text = LocalContext.current.getString(R.string.home),
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 20.dp)

        )
        Row(
            modifier = Modifier
                .width(100.dp)
                .align(Alignment.CenterEnd)
                .padding(end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                Icons.Filled.Notifications,
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .clickable {  }
            )
            Icon(
                Icons.Outlined.ExitToApp,
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .clickable { onLogoutIconClicked() }
            )

        }

    }
}