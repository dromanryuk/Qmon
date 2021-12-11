package com.qmon.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.qmon.R

private val AtypFontFamily = FontFamily(
    Font(R.font.atyp_bold, weight = FontWeight.Bold),
    Font(R.font.atyp_medium, weight = FontWeight.Medium),
    Font(R.font.atyp_thin, weight = FontWeight.Thin),
)

val Typography = Typography(
    defaultFontFamily = AtypFontFamily,
    body1 = TextStyle(
        fontFamily = AtypFontFamily,
        fontWeight = FontWeight.Thin,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        fontFamily = AtypFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 10.sp
    ),
    h2 = TextStyle(
        fontFamily = AtypFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp
    )
)