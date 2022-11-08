package com.example.take_note_kotlin_compose.di

import android.app.Application
import androidx.room.Room
import com.example.take_note_kotlin_compose.feature_note.data.data_source.NoteContentDao
import com.example.take_note_kotlin_compose.feature_note.data.data_source.NoteDatabase
import com.example.take_note_kotlin_compose.feature_note.data.repository.NoteContentIRepositoryImpl
import com.example.take_note_kotlin_compose.feature_note.data.repository.NoteRepositoryImpl
import com.example.take_note_kotlin_compose.feature_note.data.repository.NoteWithContentRepositoryImpl
import com.example.take_note_kotlin_compose.feature_note.domain.model.NoteContent
import com.example.take_note_kotlin_compose.feature_note.domain.model.NoteWithContent
import com.example.take_note_kotlin_compose.feature_note.domain.repository.NoteContentRepository
import com.example.take_note_kotlin_compose.feature_note.domain.repository.NoteRepository
import com.example.take_note_kotlin_compose.feature_note.domain.repository.NoteWithContentRepository
import com.example.take_note_kotlin_compose.feature_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application):
            NoteDatabase{
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository{
        return NoteRepositoryImpl(db.noteDao);
    }

    @Provides
    @Singleton
    fun provideNoteContentRepository(db: NoteDatabase)
        :NoteContentRepository{
        return NoteContentIRepositoryImpl(db.noteContentDao)
    }

    @Provides
    @Singleton
    fun provideNoteWithContentRepository(db: NoteDatabase)
            :NoteWithContentRepository{
        return NoteWithContentRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNotesUseCases(
        noteRepository: NoteRepository,
        noteContentWithContentRepository: NoteWithContentRepository,
        noteContentRepository: NoteContentRepository
    ): NoteUseCases{
        return NoteUseCases(
            getAllNote = GetAllNote(noteContentWithContentRepository),
            deleteNote = DeleteNote(noteRepository),
            deleteNoteContent = DeleteNoteContent(noteContentRepository),
            addNote = AddNote(noteRepository)
        )
    }

}
