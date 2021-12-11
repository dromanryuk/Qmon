package com.qmon.presentation.instruction

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qmon.R
import com.qmon.ui.theme.QmonTheme

@Composable
fun InstructionContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painterResource(id = R.drawable.logo),
            modifier = Modifier.size(200.dp, 100.dp),
            contentDescription = null,
        )
        Text(
            text = "Как заработать в " +
                    "приложении?",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.h6,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Для заработка в приложении " +
                    "Qmon необходимо честно " +
                    "отвечать на вопросы от " +
                    "коммерческих компаний, за " +
                    "это вы получите Q-монеты. Их " +
                    "можно обменять на реальные " +
                    "деньги и вывести к себе на " +
                    "карту или через " +
                    "международные платежные " +
                    "системы.",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Thin
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Монеты можно обменять по " +
                    "курсу 10\$ за 1000 монет.",
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.body2,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Thin
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun InstructionContentPreview() {
    QmonTheme {
        InstructionContent()
    }
}