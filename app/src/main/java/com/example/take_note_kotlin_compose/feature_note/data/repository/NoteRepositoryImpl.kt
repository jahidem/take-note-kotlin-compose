package com.example.take_note_kotlin_compose.feature_note.data.repository

import com.example.take_note_kotlin_compose.feature_note.data.data_source.NoteDao
import com.example.take_note_kotlin_compose.feature_note.domain.repository.NoteRepository

class NoteRepositoryImpl: NoteRepository (
    private val dao: NoteDao
    ){

}