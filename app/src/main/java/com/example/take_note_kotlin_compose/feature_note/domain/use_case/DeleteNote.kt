package com.example.take_note_kotlin_compose.feature_note.domain.use_case

import com.example.take_note_kotlin_compose.feature_note.domain.model.Note
import com.example.take_note_kotlin_compose.feature_note.domain.repository.NoteRepository
import com.example.take_note_kotlin_compose.feature_note.domain.repository.NoteWithContentRepository

class DeleteNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}