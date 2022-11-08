package com.example.take_note_kotlin_compose.feature_note.presentation.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.take_note_kotlin_compose.feature_note.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private  val noteUseCases: NoteUseCases
) : ViewModel(){


    private val _state = mutableStateOf(NoteState())
    val state: State<NoteState> = _state

    private var getNotesJob: Job? = null
    init {
        viewModelScope.launch {
            getNotes()
        }
    }
    fun onEvent(noteEvent: NoteEvent){
        when(noteEvent){
            is NoteEvent.DeleteNote -> {
                viewModelScope.launch {
                    noteUseCases.deleteNote(noteEvent.note)
                }
            }

            is NoteEvent.AddNote -> {
                viewModelScope.launch {
                    noteUseCases.addNote(noteEvent.note)
                }
            }
            is NoteEvent.DeleteNoteContent -> {
                viewModelScope.launch {
                    noteUseCases.deleteNoteContent(noteEvent.noteContent)
                }
            }
            is NoteEvent.ToggleSidebar ->{
                _state.value = _state.value.copy(showSideBar = !state.value.showSideBar)
            }

            is NoteEvent.ToggleTheme -> {
                _state.value = _state.value.copy(enableDarkTheme = !state.value.enableDarkTheme)
            }


        }
    }

    private suspend fun getNotes(){
        getNotesJob?.cancel()
        getNotesJob = noteUseCases.getAllNote()
            .onEach {
                notes ->
                _state.value = state.value.copy(notes = notes)
            }
            .launchIn(viewModelScope)
    }
}