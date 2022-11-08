package com.example.take_note_kotlin_compose.feature_note.presentation.notes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.take_note_kotlin_compose.R
import com.example.take_note_kotlin_compose.feature_note.domain.model.Note
import com.example.take_note_kotlin_compose.feature_note.domain.model.noteList
import com.example.take_note_kotlin_compose.ui.theme.White100
import com.example.take_note_kotlin_compose.ui.theme.notesSubTittle
import com.example.take_note_kotlin_compose.ui.theme.notesTittle

@Composable
fun SidebarScreen(){

    Column (modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(0.64f )
        .background(MaterialTheme.colors.secondary)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Spacer(modifier = Modifier.weight(0.26f))
            ScrollingNotes(Modifier.weight(0.74f, fill = false), noteList)
        }
        BottomNavs()
    }
}
@Composable
fun ScrollingNotes(modifier: Modifier, noteList: List<Note>){
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier) ,
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(30.dp)
    ) {
        items(noteList) { note ->
            NotesItem(note.tittle, note.timeStamp, note.isActive)
        }
    }
}



@Composable
fun NotesItem(
    heading: String,
    timeStamp: String,
    activeNote: Boolean
) {
    Row (modifier = Modifier .padding(vertical = 30.dp),
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

        Column(
        ) {
            Text(
                text = "#" + heading,
                style = notesTittle,
                maxLines = 1,
                overflow = TextOverflow.Clip
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


