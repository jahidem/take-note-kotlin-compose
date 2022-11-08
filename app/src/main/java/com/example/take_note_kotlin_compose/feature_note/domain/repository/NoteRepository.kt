package com.example.take_note_kotlin_compose.feature_note.domain.repository

import com.example.take_note_kotlin_compose.feature_note.domain.model.Note
import com.example.take_note_kotlin_compose.feature_note.domain.model.NoteContent
import com.example.take_note_kotlin_compose.feature_note.domain.model.NoteWithContent
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}