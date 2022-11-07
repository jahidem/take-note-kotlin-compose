package com.example.take_note_kotlin_compose

import android.graphics.Paint.Align
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.take_note_kotlin_compose.ui.theme.Gray100
import com.example.take_note_kotlin_compose.ui.theme.White100
import com.example.take_note_kotlin_compose.ui.theme.notesSubTittle
import com.example.take_note_kotlin_compose.ui.theme.notesTittle

@Composable
fun SidebarScreen(showSideBar: Boolean){

    Column (modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(if (showSideBar) 0.64f else 0f)
        .background(MaterialTheme.colors.secondary)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Spacer(modifier = Modifier.weight(0.25f))
            ScrollingNotes(Modifier.weight(0.75f, fill = false))
        }
        BottomNavs()
    }
}
@Composable
fun ScrollingNotes(modifier: Modifier){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .then(modifier)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        NotesItem("Waiting", "last sec ago", true)
        NotesItem(heading = "Hopping", timeStamp = "Thu, Aug 27", false)
        NotesItem("Waiting", "last sec ago", true)
        NotesItem(heading = "Hopping", timeStamp = "Thu, Aug 27", false)
        NotesItem("Waiting", "last sec ago", true)
        NotesItem(heading = "Hopping", timeStamp = "Thu, Aug 27", false)
        NotesItem("Waiting", "last sec ago", true)
        NotesItem(heading = "Hopping", timeStamp = "Thu, Aug 27", false)
        NotesItem("Waiting", "last sec ago", true)
        NotesItem(heading = "Hopping", timeStamp = "Thu, Aug 27", false)
        NotesItem("Waiting", "last sec ago", true)
        NotesItem(heading = "Hopping", timeStamp = "Thu, Aug 27", false)

    }
}



@Composable
fun NotesItem(
    heading: String,
    timeStamp: String,
    activeNote: Boolean
) {
    Row (modifier = Modifier
        .padding(vertical = 30.dp),
        verticalAlignment = Alignment.CenterVertically
        ) {
        if (activeNote)
            Box(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(8.dp)
                    .clip(CircleShape)

                    .background(White100)
            )
            {

            }

        Column(
        ) {
            Text(
                text = "#" + heading,
                style = notesTittle
            )
            Text(
                text = timeStamp,
                style = notesSubTittle,
                color = Color(0xFFa7c6c0)
            )
        }
    }
}
@Composable
fun BottomNavs(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 50.dp)
        , horizontalAlignment = Alignment.CenterHorizontally) {

        BottomNavItem("ADD NOTES", R.drawable.add_fill0_wght400_grad0_opsz48)
        BottomNavItem("SETTINGS", R.drawable.settings_fill0_wght400_grad0_opsz48)
    }
}

@Composable
fun BottomNavItem(text: String,
    imageID: Int){
    Row(modifier = Modifier
        .padding(vertical = 12.dp)
            ,verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = imageID),
            colorFilter = ColorFilter.tint(color = Color(0xFFa7c6c0)),
            modifier = Modifier
                .padding(end = 5.dp)
                .size(25.dp),
            contentDescription = "add notes"
        )
        Text(
            text = text,
            style = notesSubTittle,
            fontSize = 16.sp,
            color = Color(0xFFa7c6c0)
        )
    }
}