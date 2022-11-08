package com.example.take_note_kotlin_compose.feature_note.domain.use_case

import com.example.take_note_kotlin_compose.feature_note.domain.model.Note
import com.example.take_note_kotlin_compose.feature_note.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note){
        repository.insertNote(note)
    }
}