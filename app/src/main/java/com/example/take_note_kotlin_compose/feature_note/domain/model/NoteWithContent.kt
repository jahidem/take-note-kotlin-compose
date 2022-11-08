package com.example.take_note_kotlin_compose.feature_note.domain.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

data class NoteWithContent(
    @Embedded
    val note: Note,
    @Relation(
        parentColumn = "noteId",
        entityColumn = "parentNoteId",
    )
    val contentList: List<NoteContent>

)
