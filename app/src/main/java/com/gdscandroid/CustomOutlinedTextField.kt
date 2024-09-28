package com.gdscandroid

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuDefaults.outlinedTextFieldColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gdscandroid.ui.theme.CheckOutOrange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    modifier: Modifier = Modifier,
    singleLine: Boolean = true,
    labelColor: Color = Color.White,
    placeholderColor: Color = Color.White,
    textColor: Color = Color.White,
    focusedBorderColor: Color = CheckOutOrange,
    unfocusedBorderColor: Color = Color.White,
    cursorColor: Color = Color.White,
    focusedLabelColor: Color = Color.White,
    unfocusedLabelColor: Color = Color.White,
    cornerRadius: Int = 16,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                color = labelColor,
            )
        },
        placeholder = {
            Text(
                text = placeholder,
                color = placeholderColor,
            )
        },
        modifier =
        modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        singleLine = singleLine,
        textStyle = MaterialTheme.typography.bodyMedium.copy(color = textColor),
        shape = RoundedCornerShape(cornerRadius.dp),
        colors =
        outlinedTextFieldColors(
            focusedBorderColor = focusedBorderColor,
            unfocusedBorderColor = unfocusedBorderColor,
            cursorColor = cursorColor,
            focusedLabelColor = focusedLabelColor,
            unfocusedLabelColor = unfocusedLabelColor,
        ),
    )
}