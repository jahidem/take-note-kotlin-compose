package com.example.take_note_kotlin_compose.feature_note.presentation.notes

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun NotesApp(
    viewModel: NoteViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    Box (modifier = Modifier.fillMaxSize()) {
        var showSideBar by rememberSaveable { mutableStateOf(false) }
        val density = LocalDensity.current
        NoteScreen(showSideBar = state.showSideBar, onPressShowSideBar = {viewModel.onEvent(NoteEvent.ToggleSidebar)})
        AnimatedVisibility(visible = state.showSideBar,
            enter = slideInHorizontally {
                // Slide in from 40 dp from the left.
                with(density) { -300.dp.roundToPx() }
            }
                    + fadeIn(
                // Fade in with the initial alpha of 0.3f.
                initialAlpha = 0f
            ),
            exit = slideOutHorizontally() + shrinkHorizontally() + fadeOut()) {
            SidebarScreen()
        }


    }
}
