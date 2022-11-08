package com.example.take_note_kotlin_compose.feature_note.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.take_note_kotlin_compose.feature_note.presentation.notes.NoteScreen
import com.example.take_note_kotlin_compose.feature_note.presentation.notes.NotesApp
import com.example.take_note_kotlin_compose.feature_note.presentation.notes.SidebarScreen
import com.example.take_note_kotlin_compose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TakenotekotlincomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                   NotesApp()
                }
            }
        }
    }
}


