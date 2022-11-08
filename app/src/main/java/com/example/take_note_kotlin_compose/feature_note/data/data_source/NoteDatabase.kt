package com.example.take_note_kotlin_compose.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.take_note_kotlin_compose.feature_note.domain.model.Note
import com.example.take_note_kotlin_compose.feature_note.domain.model.NoteContent

@Database(
    entities = [Note::class, NoteContent::class],
    version = 1
)
abstract class NoteDatabase: RoomDatabase(){
    abstract val noteDao: NoteDao
    abstract val noteContentDao: NoteContentDao
}
