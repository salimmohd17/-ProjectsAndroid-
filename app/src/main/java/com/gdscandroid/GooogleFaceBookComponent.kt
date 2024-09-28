package com.gdscandroid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GoogleFaceBookComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.googleplus),
            contentDescription = "Facebook",
            tint = Color.Unspecified,
            modifier = Modifier.size(48.dp),
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "...... or ......",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            painter = painterResource(id = R.drawable.facebook),
            contentDescription = "Google Plus",
            tint = Color.Unspecified,
            modifier = Modifier.size(48.dp),
        )
    }
}