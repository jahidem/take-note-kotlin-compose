package com.example.take_note_kotlin_compose.feature_note.domain.repository

import com.example.take_note_kotlin_compose.feature_note.domain.model.NoteContent

interface NoteContentRepository {
    suspend fun insertNoteContent(note: NoteContent)

    suspend fun deleteNoteContent(note: NoteContent)
}