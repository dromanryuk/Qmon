package com.qmon.presentation.daily_bonus

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.qmon.R
import com.qmon.ui.theme.QmonTheme

@Composable
fun DefaultRewardPanel(
    day: Int,
    isCollected: Boolean,
    onCollect: () -> Unit
) {
    val panelAlpha = if (isCollected) 0.5f else 1f
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(5.dp))
            .background(Color(0xffffbeb2).copy(alpha = panelAlpha))
            .alpha(panelAlpha),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.padding(start = 20.dp, end = 30.dp, top = 10.dp, bottom = 10.dp),
            text = "$day День",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 26.sp
        )
        DefaultRewardButton(day = day, isCollected = isCollected, onCollect = onCollect)
    }
}

@Composable
fun DefaultRewardButton(day: Int, isCollected: Boolean, onCollect: () -> Unit) {
    val text =
        if (isCollected)
            "Получено"
        else
            LocalContext.current.resources.getQuantityString(R.plurals.get_coins, day, day)
    Button(
        onClick = onCollect,
        modifier = Modifier
            .padding(10.dp)
            .requiredWidth(160.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Row(
            modifier = Modifier
                .background(btnGradient)
                .fillMaxWidth()
                .height(60.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = text,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

private val btnGradient = Brush.verticalGradient(
    listOf(
        Color(0xff009ff2),
        Color(0xff3762ff)
    )
)

@Preview(showBackground = true)
@Composable
private fun CollectedDefaultRewardPanelPreview() {
    QmonTheme {
        DefaultRewardPanel(day = 9, isCollected = true, onCollect = {})
    }
}

@Preview
@Composable
private fun NewDefaultRewardPanelPreview() {
    QmonTheme {
        DefaultRewardPanel(day = 10, isCollected = false, onCollect = {})
    }
}