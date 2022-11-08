package com.example.take_note_kotlin_compose.feature_note.presentation.notes

import com.example.take_note_kotlin_compose.feature_note.domain.model.Note
import com.example.take_note_kotlin_compose.feature_note.domain.model.NoteWithContent


data class NoteState(
    val notes: List<NoteWithContent> = emptyList(),
    val showSideBar:Boolean = false,
    val enableDarkTheme: Boolean = true
)
