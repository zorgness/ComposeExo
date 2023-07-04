import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.efikeyscompose.R
import com.example.efikeyscompose.presentation.ui.theme.ColorPrimary

@Composable
fun HeaderCommon(
    title: String,
    handleNavBack: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp,
                vertical = 30.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.h2,
            color = ColorPrimary
        )

        Image(
            painterResource(
                id = R.drawable.modalcross_icon
            ),
            modifier = Modifier
                .size(28.dp)
                .clickable { handleNavBack() },
            contentDescription = null,
        )
    }
}
