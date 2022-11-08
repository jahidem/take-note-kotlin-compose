package com.example.take_note_kotlin_compose.feature_note.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity
data class NoteContent(
    @PrimaryKey(autoGenerate = true)
    val noteContentId: Int = 1,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    val contentType: Int,
    val imageData: ByteArray? = null,
    val textData: String? = null,
    val parentNoteId: Int){
    companion object{
        val TEXT = 0
        val IMAGE = 1
    }

}

