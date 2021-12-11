package com.qmon.presentation.overview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.qmon.R

@Composable
fun OverviewContent(
    navigateToQuestionScreen: () -> Unit,
    navigateToDailyBonusScreen: () -> Unit,
    navigateToWithdrawalScreen: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painterResource(id = R.drawable.logo),
            contentDescription = "app logo",
        )
        Text(
            text = "Зарабатывайте на коммерческих опросах",
            style = MaterialTheme.typography.h5,
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium
        )
        DefaultOverviewButton(
            navigateToQuestionScreen,
            Color(0xff00ae5d),
            "Проходить опросы и зарабатывать"
        )
        DefaultOverviewButton(
            navigateToDailyBonusScreen,
            Color(0xff0046d0),
            "Ежедневный бонус"
        )
        DefaultOverviewButton(
            navigateToWithdrawalScreen,
            Color(0xff0046d0),
            "Вывод средств"
        )
    }
}