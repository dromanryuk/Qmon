package com.qmon.presentation.overview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.qmon.R

@Composable
fun OverviewContent(
    navigateToQuestionScreen: () -> Unit,
    navigateToDailyBonusScreen: () -> Unit,
    navigateToWithdrawalScreen: () -> Unit,
) {
    Surface {
        Column(
            modifier = Modifier
                .padding(40.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painterResource(id = R.drawable.logo),
                contentDescription = "app logo",
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Зарабатывайте на коммерческих опросах",
                style = MaterialTheme.typography.h5,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(30.dp))
            DefaultOverviewButton(
                navigateToQuestionScreen,
                Color(0xff00ae5d),
                "Проходить опросы и зарабатывать"
            )
            Spacer(modifier = Modifier.height(30.dp))
            DefaultOverviewButton(
                navigateToDailyBonusScreen,
                Color(0xff0046d0),
                "Ежедневный бонус"
            )
            Spacer(modifier = Modifier.height(30.dp))
            DefaultOverviewButton(
                navigateToWithdrawalScreen,
                Color(0xff0046d0),
                "Вывод средств"
            )
        }
    }
}