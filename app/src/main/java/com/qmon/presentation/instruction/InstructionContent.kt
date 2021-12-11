package com.qmon.presentation.instruction

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qmon.R

@Composable
fun InstructionContent() {
    Surface {
        Column(
            modifier = Modifier
                .padding(40.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painterResource(id = R.drawable.logo),
                modifier = Modifier.size(200.dp, 100.dp),
                contentDescription = "app logo",
            )
            Text(
                text = "Как заработать в\n" +
                        "приложении?",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h6,
                color = Color.Black,
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Для заработка в приложении\n" +
                        "Qmon необходимо честно\n" +
                        "отвечать на вопросы от\n" +
                        "коммерческих компаний, за\n" +
                        "это вы получите Q-монеты. Их\n" +
                        "можно обменять на реальные\n" +
                        "деньги и вывести к себе на\n" +
                        "карту или через\n" +
                        "международные платежные\n" +
                        "системы.",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.body2,
                color = Color.Black,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Монеты можно обменять по\n" +
                        "курсу 10\$ за 1000 монет.",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.body2,
                color = Color.Black,
                fontSize = 18.sp
            )

        }
    }
}