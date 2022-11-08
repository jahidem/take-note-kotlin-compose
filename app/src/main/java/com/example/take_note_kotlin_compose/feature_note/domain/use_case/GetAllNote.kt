package com.example.take_note_kotlin_compose.feature_note.domain.use_case

import com.example.take_note_kotlin_compose.feature_note.domain.model.NoteWithContent
import com.example.take_note_kotlin_compose.feature_note.domain.repository.NoteWithContentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllNote(
    private val repository: NoteWithContentRepository
) {
    suspend operator fun invoke(): Flow<List<NoteWithContent>>{
        return repository.getNoteWithContent().map{
            notes-> notes.sortedByDescending { it.note.timeStamp }
        }
    }
}