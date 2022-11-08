package com.example.take_note_kotlin_compose.feature_note.data.repository

import com.example.take_note_kotlin_compose.feature_note.data.data_source.NoteDao
import com.example.take_note_kotlin_compose.feature_note.domain.model.Note
import com.example.take_note_kotlin_compose.feature_note.domain.model.NoteContent
import com.example.take_note_kotlin_compose.feature_note.domain.model.NoteWithContent
import com.example.take_note_kotlin_compose.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
): NoteRepository {
    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}
