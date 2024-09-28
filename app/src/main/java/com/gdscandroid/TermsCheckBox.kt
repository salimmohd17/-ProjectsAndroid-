package com.gdscandroid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.gdscandroid.ui.theme.GdscGreen

@Composable
fun TermsCheckbox(
    isChecked: MutableState<Boolean>,
) {
    Row(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Checkbox(
            checked = isChecked.value,
            onCheckedChange = { isChecked.value = it },
        )

        Spacer(modifier = Modifier.size(8.dp))

        val termsText = "I accept Terms & Conditions"
        val annotatedString =
            AnnotatedString.Builder(termsText).apply {
                addStyle(
                    style =
                    SpanStyle(
                        color = GdscGreen,
                        textDecoration = TextDecoration.Underline,
                    ),
                    start = 9,
                    end = termsText.length,
                )
            }.toAnnotatedString()

        ClickableText(
            text = annotatedString,
            onClick = { offset ->
                if (offset >= 9 && offset <= termsText.length) {
                    // Handle the click event on "terms and conditions"
                   // navController.navigate(Screens.TermsScreen.route)
                }
            },
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.White),
        )
    }
}