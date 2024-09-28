package com.gdscandroid

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gdscandroid.ui.theme.DignifyBackground
import com.gdscandroid.ui.theme.DignifyGreen

@Composable
fun SignUpScreen() {


    val nameState = remember { mutableStateOf("") }

    val isNameValid = remember { mutableStateOf(true) }

    fun validateInputs(): Boolean {
        val isNameValidResult = nameState.value.isNotBlank()
        isNameValid.value = isNameValidResult
        return isNameValidResult
    }

    Scaffold { innerPadding ->
        Surface(
            modifier =
            Modifier
                .fillMaxSize()
                .background(
                    brush =
                    Brush.linearGradient(
                        colors =
                        listOf(
                            DignifyGreen,
                            DignifyBackground,
                        ),
                        start = androidx.compose.ui.geometry.Offset(1000f, 1000f),
                        end = androidx.compose.ui.geometry.Offset(900f, 0f),
                    ),
                )
                .padding(innerPadding),
            color = Color.Transparent,
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        text = "Sign Up",
                        fontSize = 50.sp,
                        style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                        color = Color.White,
                        textAlign = TextAlign.Center,
                    )

                    Spacer(modifier = Modifier.weight(0.1f))

                    Text(
                        modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        text = "Create your account",
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.weight(0.1f))

                    UserNameField(nameState, isNameValid.value)

                    if (!isNameValid.value) {
                        Text(
                            text = "Name cannot be empty",
                            color = Color.Red,
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }

                    Spacer(modifier = Modifier.weight(3f))


                }
            }
        }
    }
}


@Composable
fun UserNameField(
    nameState: MutableState<String>,
    isValid: Boolean,
) {
    CustomOutlinedTextField(
        value = nameState.value,
        onValueChange = { newText -> nameState.value = newText },
        label = "Name",
        placeholder = "Guardian Angel",
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPreview() {
    SignUpScreen()
}