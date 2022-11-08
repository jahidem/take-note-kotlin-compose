package com.example.take_note_kotlin_compose.feature_note.domain.use_case

import com.example.take_note_kotlin_compose.feature_note.domain.model.Note

class NoteUseCases(
    val getAllNote: GetAllNote,
    val deleteNote: DeleteNote,
    val deleteNoteContent: DeleteNoteContent,
    val addNote: AddNote

)