package com.example.take_note_kotlin_compose.feature_note.data.data_source

import androidx.room.*
import com.example.take_note_kotlin_compose.feature_note.domain.model.Note
import com.example.take_note_kotlin_compose.feature_note.domain.model.NoteWithContent
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Transaction
    @Query("SELECT * FROM Note")
    fun getAllNoteWithContent(): Flow<List<NoteWithContent>>

    @Transaction
    @Query("SELECT * FROM Note WHERE noteId = :id")
    suspend fun getNoteByID(id: Int): NoteWithContent?

}