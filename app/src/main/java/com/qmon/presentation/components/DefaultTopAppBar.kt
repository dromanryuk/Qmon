package com.qmon.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qmon.R
import com.qmon.ui.theme.QmonTheme

@Composable
fun DefaultTopAppBar(
    coins: Int,
    navigateToInstructionScreen: () -> Unit
) {
    TopAppBar(
        backgroundColor = Color(0xff0b0393),
        modifier = Modifier.clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)),
        elevation = AppBarDefaults.TopAppBarElevation
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painterResource(id = R.drawable.qcoin),
                    contentDescription = "description of the image",
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Монеты: $coins",
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )
            }
            Button(
                onClick = { navigateToInstructionScreen() },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text("Как заработать?")
            }
        }
    }
}

@Preview
@Composable
private fun DefaultTopAppBarPreview() {
    QmonTheme {
        DefaultTopAppBar(coins = 1000, navigateToInstructionScreen = {})
    }
}

