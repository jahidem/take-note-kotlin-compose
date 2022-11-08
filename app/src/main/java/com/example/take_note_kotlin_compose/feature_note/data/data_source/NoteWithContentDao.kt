package com.example.take_note_kotlin_compose.feature_note.data.data_source

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.example.take_note_kotlin_compose.feature_note.domain.model.NoteWithContent

@Dao
interface NoteWithContentDao {

    @Transaction
    @Query("SELECT * FROM Note")
    fun getAllNoteWithContent(): List<NoteWithContent>

    @Transaction
    @Query("SELECT * FROM Note WHERE noteId = :id")
    suspend fun getNoteByID(id: Int): NoteWithContent?


}