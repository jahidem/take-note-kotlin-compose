package com.example.take_note_kotlin_compose.feature_note.domain.use_case

import android.provider.ContactsContract.CommonDataKinds.Note
import com.example.take_note_kotlin_compose.feature_note.domain.model.NoteContent
import com.example.take_note_kotlin_compose.feature_note.domain.repository.NoteContentRepository

class DeleteNoteContent(
    private val repository: NoteContentRepository
) {
    suspend operator fun invoke(noteContent: NoteContent){
        repository.deleteNoteContent(noteContent)
    }
}