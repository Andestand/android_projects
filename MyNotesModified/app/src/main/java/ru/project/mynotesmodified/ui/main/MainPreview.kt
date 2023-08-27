package ru.project.mynotesmodified.ui.main

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import ru.project.mynotesmodified.data.arrays.ArrayNotes
import ru.project.mynotesmodified.data.room.MyRoomManager
import ru.project.mynotesmodified.domain.models.Note
import ru.project.mynotesmodified.ui.create.CreateNote
import ru.project.mynotesmodified.ui.noteTemplate.NoteTemplate
import ru.project.mynotesmodified.ui.theme.appName

private lateinit var db: MyRoomManager
private var array = ArrayNotes.array

fun getDataBase(context: Context) {
    db = Room.databaseBuilder(
        context,
        MyRoomManager::class.java,
        "database"
    ).fallbackToDestructiveMigration().allowMainThreadQueries().build()

    for (note in db.noteDAO().getNotes()) {
        array.remove(
            element = note
        )
        array.add(
            element = note
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MainPreview() {
    Column(
        modifier = Modifier.fillMaxSize()

    ) {
        CreateNote()
        /*TopAppBar(
            title = {
                Text(
                    modifier = Modifier,
                    text = appName,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(count = array.size) {
                for (note in array) {
                    NoteTemplate(
                        note = note
                    )
                }
            }

        }*/
    }
}