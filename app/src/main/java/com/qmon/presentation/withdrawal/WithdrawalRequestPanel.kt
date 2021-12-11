package com.qmon.presentation.withdrawal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qmon.R

@Composable
fun WithdrawalRequestPanel(coins: Int = 0) {
    val gradient = Brush.verticalGradient(listOf(Color(0xff005bff), Color(0xff002dd0)))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 40.dp, end = 40.dp)
            .background(Color(0xffcde8d4)),
        shape = RoundedCornerShape(5.dp),
    ) {
        Column(
            modifier = Modifier.background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp, top = 10.dp),
                text = "Баланс монет: $coins",
                style = MaterialTheme.typography.h5,
                color = Color.Black,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp),
                text = "1000 монет = 10$",
                style = MaterialTheme.typography.h5,
                color = Color(0xff0b0393),
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(5.dp))
            WithdrawalButton(gradient)
            Spacer(modifier = Modifier.height(5.dp))
            Image(
                painterResource(id = R.drawable.logos),
                //modifier = Modifier.size(200.dp, 100.dp),
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp, bottom = 15.dp),
                contentDescription = "app logo",
            )
        }
    }
}

@Composable
fun WithdrawalButton(gradient: Brush) {
    Button(
        onClick = { },
        modifier = Modifier
            .padding(10.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Row(
            modifier = Modifier
                .background(gradient)
                .fillMaxWidth()
                .height(45.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Подать заявку на вывод",
                style = MaterialTheme.typography.h6,
                color = Color.White,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}