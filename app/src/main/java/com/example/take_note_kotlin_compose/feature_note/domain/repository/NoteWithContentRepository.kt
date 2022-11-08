package com.example.take_note_kotlin_compose.feature_note.domain.repository

import com.example.take_note_kotlin_compose.feature_note.domain.model.NoteWithContent
import kotlinx.coroutines.flow.Flow

interface NoteWithContentRepository {
    suspend fun getNoteWithContent(): Flow<List<NoteWithContent>>

    suspend fun getNoteWithContentById(noteId: Int): NoteWithContent?
}