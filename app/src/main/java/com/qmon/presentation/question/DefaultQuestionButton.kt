package com.qmon.presentation.question

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DefaultQuestionButton(text: String, gradient: Brush, showDialog: MutableState<Boolean>) {
    Button(
        onClick = { showDialog.value = true },
        modifier = Modifier
            .padding(10.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Row(
            modifier = Modifier
                .background(gradient)
                .fillMaxWidth()
                .height(80.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = text,
                style = MaterialTheme.typography.h6,
                color = Color.White,
                fontSize = 26.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}