package com.gdscandroid

import android.app.Activity
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.gdscandroid.ui.theme.GdscBackground
import com.gdscandroid.ui.theme.GdscGreen

@Composable
fun SignUpScreen() {

    val context = LocalContext.current

    val nameState = remember { mutableStateOf("") }
    val phoneState = remember { mutableStateOf("") }
    val aliasState = remember { mutableStateOf("") }

    val isNameValid = remember { mutableStateOf(true) }
    val isPhoneValid = remember { mutableStateOf(true) }
    val isAliasValid = remember { mutableStateOf(true) }
    val isTermsChecked = remember { mutableStateOf(false) }

    fun validateInputs(): Boolean {
        val isNameValidResult = nameState.value.isNotBlank()
        val isPhoneValidResult = phoneState.value.length == 12 && phoneState.value.startsWith("254")
        val isAliasValidResult = aliasState.value.isNotBlank()

        isNameValid.value = isNameValidResult
        isPhoneValid.value = isPhoneValidResult
        isAliasValid.value = isAliasValidResult

        return isNameValidResult && isPhoneValidResult && isAliasValidResult && isTermsChecked.value
    }



    LaunchedEffect(Unit) {
        // Set the system bars color to match the app's background
        val window = (context as Activity).window
        window.statusBarColor = GdscBackground.toArgb()
        window.navigationBarColor = GdscBackground.toArgb()
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightStatusBars =
            false
        WindowCompat.getInsetsController(window, window.decorView).isAppearanceLightNavigationBars =
            false
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
                            GdscGreen,
                            GdscBackground,
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

                    PhoneNumberField(phoneState, isPhoneValid.value)

                    if (!isPhoneValid.value) {
                        Text(
                            text = "Phone number must be 12 characters and start with 254",
                            color = Color.Red,
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }

                    AliasField(aliasState, isAliasValid.value)
                    if (!isAliasValid.value) {
                        Text(
                            text = "Alias cannot be empty",
                            color = Color.Red,
                            style = MaterialTheme.typography.bodySmall,
                        )
                    }

                    Spacer(modifier = Modifier.weight(0.4f))

                    TermsCheckbox(isTermsChecked)

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
        placeholder = "GDSCTeam",
    )
}


@Composable
fun PhoneNumberField(
    phoneNumberState: MutableState<String>,
    isValid: Boolean,
) {
    CustomOutlinedTextField(
        value = phoneNumberState.value,
        onValueChange = { newText -> phoneNumberState.value = newText },
        label = "Phone Number",
        placeholder = "254 700 000 000",
    )
}

@Composable
fun AliasField(
    aliasState: MutableState<String>,
    isValid: Boolean,
) {
    CustomOutlinedTextField(
        value = aliasState.value,
        onValueChange = { newText -> aliasState.value = newText },
        label = "Alias",
        placeholder = "Guardian Angel",
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPreview() {
    SignUpScreen()
}