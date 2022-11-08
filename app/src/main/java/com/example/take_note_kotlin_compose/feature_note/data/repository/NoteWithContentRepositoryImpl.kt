package com.example.take_note_kotlin_compose.feature_note.data.repository

import com.example.take_note_kotlin_compose.feature_note.data.data_source.NoteDao
import com.example.take_note_kotlin_compose.feature_note.domain.model.NoteWithContent
import com.example.take_note_kotlin_compose.feature_note.domain.repository.NoteWithContentRepository
import kotlinx.coroutines.flow.Flow

class NoteWithContentRepositoryImpl(
    private val dao: NoteDao
): NoteWithContentRepository {
    override suspend fun getNoteWithContent(): Flow<List<NoteWithContent>> {
        return dao.getAllNoteWithContent()
    }

    override suspend fun getNoteWithContentById(noteId: Int): NoteWithContent? {
        return dao.getNoteByID(noteId)
    }
}