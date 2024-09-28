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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignUpScreen() {

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
                            Color.Black,
                            Color.Black,
                        ),
                        start = androidx.compose.ui.geometry.Offset(1000f, 1000f),
                        end = androidx.compose.ui.geometry.Offset(1000f, 1000f),
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

                    Text(
                        modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),
                        text = "Create your account",
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.weight(4f))

                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPreview() {
    SignUpScreen()
}