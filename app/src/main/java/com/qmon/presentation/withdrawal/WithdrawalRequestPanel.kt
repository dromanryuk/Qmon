package com.qmon.presentation.withdrawal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.qmon.R
import com.qmon.presentation.components.ButtonColor
import com.qmon.presentation.components.DefaultTextButton
import com.qmon.ui.theme.QmonTheme

@Composable
fun WithdrawalRequestPanel(coins: Int) {
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
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp, bottom = 15.dp),
                contentDescription = "app logo",
            )
        }
    }
}

@Composable
fun WithdrawalButton(gradient: Brush) {
    var showDialog by remember { mutableStateOf(false) }
    Button(
        onClick = { showDialog = true },
        modifier = Modifier.padding(10.dp),
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
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
    }
    if (showDialog)
        Dialog(onDismissRequest = { showDialog = false }) {
            NotEnoughCoinsDialogContent(onDismiss = {showDialog = false})
        }
}

@Composable
private fun NotEnoughCoinsDialogContent(onDismiss: () -> Unit) {
    Card {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Ваш баланс недостаточен для вывода",
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            DefaultTextButton(
                text = "ОК",
                onClick = onDismiss,
                color = ButtonColor.BLUE.color,
                padding = 0.dp
            )
        }
    }
}

@Preview
@Composable
private fun NotEnoughCoinsDialogContentPreview() {
    QmonTheme {
        NotEnoughCoinsDialogContent({})
    }
}