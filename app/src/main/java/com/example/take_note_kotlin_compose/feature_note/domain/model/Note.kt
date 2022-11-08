package com.example.take_note_kotlin_compose.feature_note.domain.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey
    val noteId: Int,
    val tittle: String,
    val content: String,
    val timeStamp: String,
    val isActive: Boolean
    )
 val noteList = listOf<Note>(
     Note(1,"Waiting" ,"sadfs sadfsad","last sec ago", true),
     Note(2,"Hopping" ,"sadfs sadfsad","Thu, Aug 27", false),
     Note(3,"Jumping" ,"sadfs sadfsad","Fri, Jan 24", false),
     Note(4,"Fetching" ,"sadfs sadfsad","Wed, Apr 22",false),
     Note(5,"Got to" ,"sadfs sadfsad","Wed, Mar 22", false),
     Note(6,"HaaH" ,"sadfs sadfsad","Sat, Sep 22", false),
     Note(7,"Hopping" ,"sadfs sadfsad","Thu, Aug 27", false),
     Note(8,"Jumping" ,"sadfs sadfsad","Fri, Jan 24", false),
     Note(9,"Fetching" ,"sadfs sadfsad","Wed, Apr 22",false),
     Note(10,"Got to" ,"sadfs sadfsad","Wed, Mar 22", false),
     Note(11,"HaaH" ,"sadfs sadfsad","Sat, Sep 22", false),
 )