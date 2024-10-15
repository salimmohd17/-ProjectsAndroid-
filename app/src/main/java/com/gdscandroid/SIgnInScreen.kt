package com.gdscandroid

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.gdscandroid.ui.theme.GDSCOnboardingText
import com.gdscandroid.ui.theme.GdscBackground
import com.gdscandroid.ui.theme.GdscGreen

@Composable
fun SignInScreen(
    navController: NavController
) {

    val context = LocalContext.current

    val phoneState = remember { mutableStateOf("") }
    val isPhoneValid = remember { mutableStateOf(true) }
    val isTermsChecked = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
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
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            GdscBackground,
                            GdscGreen
                        ),
                        start = androidx.compose.ui.geometry.Offset(800f, 1000f),
                        end = androidx.compose.ui.geometry.Offset(900f, 0f)
                    ),
                )
                .padding(innerPadding),
            color = Color.Transparent
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        text = "SignIn",
                        color = Color.White,
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.weight(0.1f))

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        text = "Let's Login",
                        color = Color.White,
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.weight(0.2f))
                    
                    phoneNumber(phoneState, isPhoneValid.value)

                    Spacer(modifier = Modifier.weight(0.2f))

                    TermsCheckbox(isChecked = isTermsChecked)

                    Spacer(modifier = Modifier.weight(0.2f))

                    Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                        Text(text = "Login", color = Color.Black)
                    }


                    Spacer(modifier = Modifier.weight(0.2f))

                    val termsText = "Don't have an account? Let's Sign Up"
                    val annotatedString =
                        AnnotatedString.Builder(termsText).apply {
                            addStyle(
                                style =
                                SpanStyle(
                                    color = GdscGreen,
                                    textDecoration = TextDecoration.Underline,
                                ),
                                start = 22,
                                end = termsText.length,
                            )
                        }
                            .toAnnotatedString()

                    ClickableText(
                        text = annotatedString,
                        onClick = { offset ->
                            if (offset >= 9 && offset <= termsText.length) {
                                // Handle the click event on "terms and conditions"
                                navController.navigate(Screens.SignUpScreen.route){
                                    popUpTo(Screens.SignInScreen.route) {inclusive = true}
                                }
                            }
                        },
                        style = MaterialTheme.typography.bodyMedium.copy(color = GDSCOnboardingText),
                    )

                    Spacer(modifier = Modifier.weight(4f))


                }
            }
        }

    }

}


@Composable
fun phoneNumber(
    phoneState: MutableState<String>,
    isValid: Boolean
) {
    CustomOutlinedTextField(
        value = phoneState.value,
        onValueChange = { newText -> phoneState.value = newText },
        label = "Phone Number",
        placeholder = "254 700 000 000"
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignIn() {
    val navcontroller = rememberNavController()
    SignInScreen(navcontroller)
}