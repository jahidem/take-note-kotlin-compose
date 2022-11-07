package com.example.take_note_kotlin_compose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.take_note_kotlin_compose.R


private val light = Font(R.font.noyh, FontWeight.W300)
private val regular = Font(R.font.noyh, FontWeight.W400)
private val medium = Font(R.font.noyh, FontWeight.W500)
private val semibold = Font(R.font.noyh, FontWeight.W600)

private val noyhFontFamily = FontFamily(light, regular, medium, semibold)

val notesTittle = TextStyle(
fontFamily = noyhFontFamily,
fontSize = 20.sp,
    letterSpacing = 4.sp
)

val notesSubTittle = TextStyle(
    fontFamily = noyhFontFamily,
    fontSize = 16.sp,
    letterSpacing = 4.sp,
    fontWeight = FontWeight.W900
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = noyhFontFamily,
        fontSize = 16.sp
    ),

            h4 = TextStyle(
            fontFamily = noyhFontFamily,
    fontSize = 28.sp
    )
    ,

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)