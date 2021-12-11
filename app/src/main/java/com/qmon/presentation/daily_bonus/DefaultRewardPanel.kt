package com.qmon.presentation.daily_bonus

import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qmon.data.local.CoinsRepository

@Composable
fun DefaultRewardPanel(
    day: Int,
    gradient: Brush,
    coinsRepository: CoinsRepository?,
    sharedPreferences: SharedPreferences
) {
    val panelAlpha = remember { mutableStateOf(1f) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
            .background(Color(0xffffbeb2).copy(alpha = panelAlpha.value))
            .alpha(panelAlpha.value),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.padding(start = 20.dp, end = 30.dp, top = 10.dp, bottom = 10.dp),
            text = "$day День",
            style = MaterialTheme.typography.h6,
            color = Color.Black,
            fontSize = 26.sp
        )
        DefaultRewardButton(day, gradient, panelAlpha, coinsRepository, sharedPreferences)
    }
}

@Composable
fun DefaultRewardButton(
    day: Int,
    gradient: Brush,
    panelAlpha: MutableState<Float>,
    coinsRepository: CoinsRepository?,
    sharedPreferences: SharedPreferences,
) {
    val text = remember { mutableStateOf("Получить \n$day монеты") }
    Button(
        onClick = {
            coinsRepository?.increaseCoinsCountBy(sharedPreferences, day)
            panelAlpha.value = 0.5f
            text.value = "Получено"
        },
        modifier = Modifier
            .padding(10.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Row(
            modifier = Modifier
                .background(gradient)
                .fillMaxWidth()
                .height(60.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = text.value,
                style = MaterialTheme.typography.h6,
                color = Color.White,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}