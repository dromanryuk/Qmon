package com.qmon.presentation.daily_bonus

import android.content.SharedPreferences
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qmon.QmonApp

@Composable
fun DailyBonusContent(sharedPreferences: SharedPreferences) {
    val gradient = Brush.verticalGradient(listOf(Color(0xff009ff2), Color(0xff3762ff)))

    val qmonApp = LocalContext.current.applicationContext as QmonApp
    val coinsRepository = qmonApp.coinsRepository

    Surface {
        Column(
            modifier = Modifier
                .padding(40.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Получайте ежедневные бонусы за открытие приложения Qmon",
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(30.dp))
            DefaultRewardPanel(1, gradient, coinsRepository, sharedPreferences)
            Spacer(modifier = Modifier.height(20.dp))
            DefaultRewardPanel(2, gradient, coinsRepository, sharedPreferences)
            Spacer(modifier = Modifier.height(20.dp))
            DefaultRewardPanel(3, gradient, coinsRepository, sharedPreferences)
            Spacer(modifier = Modifier.height(20.dp))
            DefaultRewardPanel(4, gradient, coinsRepository, sharedPreferences)
        }
    }
}