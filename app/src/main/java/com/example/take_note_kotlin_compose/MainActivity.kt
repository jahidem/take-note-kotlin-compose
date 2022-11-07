package com.example.take_note_kotlin_compose

import BottomActions
import NoteContent
import NoteScreen
import StyledButton
import TopBar
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.take_note_kotlin_compose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TakenotekotlincomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                   NotesApp()
                }
            }
        }
    }
}

@Composable
fun NotesApp(){

    Box (modifier = Modifier.fillMaxSize()) {
        var showSideBar by rememberSaveable { mutableStateOf(false) }
        NoteScreen(showSideBar = showSideBar, onPressShowSideBar = {showSideBar = !showSideBar})
        SidebarScreen(showSideBar = showSideBar)

    }
}

class MainViewModel : ViewModel(){
    private  val _showSideBar: MutableLiveData<Boolean> = MutableLiveData(false)
    val showSideBar: LiveData<Boolean> = _showSideBar

    fun onPressShowSideBar(){
        _showSideBar.value =  !(showSideBar.value)!!
    }
}



