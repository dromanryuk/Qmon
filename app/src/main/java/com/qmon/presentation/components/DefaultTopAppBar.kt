package com.qmon.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsPadding
import com.qmon.QmonApp
import com.qmon.R

@Composable
fun DefaultTopAppBar(navigateToInstructionScreen: () -> Unit) {

    val qmonApp = LocalContext.current.applicationContext as QmonApp
    val coinsRepository = qmonApp.coinsRepository
    val coins = coinsRepository?.coins

    Surface {
        TopAppBar(
            backgroundColor = Color(0xff0b0393),
            modifier = Modifier
                .statusBarsPadding()
                .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)),
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
                        text = "Монеты: ${coins?.collectAsState()?.value}",
                        style = MaterialTheme.typography.h6,
                        color = Color.White
                    )
                }
                Button(
                    onClick = { navigateToInstructionScreen() },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White,
                        contentColor = Color.Black)
                ) {
                    Text("Как заработать?")
                }
            }
        }
    }
}

