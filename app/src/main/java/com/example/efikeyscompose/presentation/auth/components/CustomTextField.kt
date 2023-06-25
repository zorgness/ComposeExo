import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun CustomTextField(
    placeholder: String?,
    value: String,
    isPassword: Boolean = false,
    handleValue: (String) -> Unit,
    maxLines: Int = 1

) {

    OutlinedTextField(
        value = value,
        onValueChange = { handleValue(it) },
        label = { Text(text = placeholder ?: "") },
        placeholder = { Text(text = placeholder ?: "") },
        visualTransformation = if (isPassword) PasswordVisualTransformation()
        else VisualTransformation.None,
        minLines = maxLines,
        maxLines = maxLines,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White
        )
    )
}