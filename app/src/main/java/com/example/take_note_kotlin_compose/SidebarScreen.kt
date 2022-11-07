package com.example.take_note_kotlin_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.take_note_kotlin_compose.ui.theme.notesSubTittle
import com.example.take_note_kotlin_compose.ui.theme.notesTittle

@Composable
fun SidebarScreen(showSideBar: Boolean){
    Column(modifier = Modifier
        .background(MaterialTheme.colors.secondary)
        .fillMaxHeight()
        .fillMaxWidth(if (showSideBar) 0.64f else 0f)
    , horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center   ) {
        NotesItem("Waiting","last sec ago")
        NotesItem(heading = "Hopping", timeStamp = "Thu, Aug 27")
    }
}

@Composable
fun NotesItem(
    heading: String,
    timeStamp: String
) {
    Column (modifier = Modifier
        .padding(vertical = 18.dp)){
        Text(
            text = "#" + heading,
            style = notesTittle
        )
        Text(text = timeStamp,
            style = notesSubTittle,
            color = Color(0xFFa7c6c0)
        )
    }
}