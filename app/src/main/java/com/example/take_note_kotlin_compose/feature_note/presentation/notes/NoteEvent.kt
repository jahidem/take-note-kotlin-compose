package com.example.take_note_kotlin_compose.feature_note.presentation.notes

import com.example.take_note_kotlin_compose.feature_note.domain.model.Note
import com.example.take_note_kotlin_compose.feature_note.domain.model.NoteContent
import com.example.take_note_kotlin_compose.feature_note.domain.use_case.DeleteNoteContent

sealed class NoteEvent{
    data class DeleteNote(val note: Note): NoteEvent()
    data class DeleteNoteContent(val noteContent: NoteContent): NoteEvent()
    data class AddNote(val note: Note): NoteEvent()
    object RestoreNote: NoteEvent()
    object RestoreNoteContent: NoteEvent()
    object ToggleSidebar: NoteEvent()
    object ToggleTheme: NoteEvent()

}
