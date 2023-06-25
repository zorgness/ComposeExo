import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.core.text.isDigitsOnly
import com.example.efikeyscompose.utils.thousandFilter

@Composable
fun CustomTextFieldKilometers(
    placeholder: String?,
    value: String,
    handleValue: (String) -> Unit,
    maxLines: Int = 1,
) {

    OutlinedTextField(
        value = value,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { if(it.isDigitsOnly()) handleValue(it) else handleValue("0") },
        label = { Text(text = placeholder ?: "") },
        placeholder = { Text(text = placeholder ?: "") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        visualTransformation = { annotatedString ->
                thousandFilter(annotatedString.text)
        },
        minLines = maxLines,
        maxLines = maxLines,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White
        ),
    )
}