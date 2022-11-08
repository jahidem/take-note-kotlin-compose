package com.example.take_note_kotlin_compose.feature_note.data.repository

import com.example.take_note_kotlin_compose.feature_note.data.data_source.NoteContentDao
import com.example.take_note_kotlin_compose.feature_note.domain.model.NoteContent
import com.example.take_note_kotlin_compose.feature_note.domain.repository.NoteContentRepository

class NoteContentIRepositoryImpl(
    private  val dao: NoteContentDao): NoteContentRepository {
    override suspend fun insertNoteContent(note: NoteContent) {
        dao.insertNote(note)
    }

    override suspend fun deleteNoteContent(note: NoteContent) {
        dao.deleteNote(note)
    }
}