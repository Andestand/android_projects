package ru.project.mynotesmodified.ui.create

import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.room.Room
import ru.project.mynotesmodified.data.arrays.ArrayNotes
import ru.project.mynotesmodified.data.room.MyRoomManager
import ru.project.mynotesmodified.domain.models.Note
import ru.project.mynotesmodified.domain.usecase.GetDateTime

val getDateTime = GetDateTime()
private lateinit var db: MyRoomManager
private var array = ArrayNotes.array

fun getDataBaseCN(context: Context) {
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
@Preview
@Composable
fun CreateNote() {
    val title = remember{mutableStateOf("заголовок")}
    val description = remember{mutableStateOf("описание")}

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = title.value,
            onValueChange = {
                    text -> title.value = text
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .defaultMinSize(
                    minHeight = 50.dp
                ).fillMaxWidth()
                .border(BorderStroke(2.2.dp, Color.Black), RoundedCornerShape(10.dp)),
            textStyle = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )

        OutlinedTextField(
            value = description.value,
            onValueChange = {
                text -> description.value = text
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .defaultMinSize(
                    minHeight = 50.dp
                ).fillMaxWidth()
                .border(BorderStroke(2.2.dp, Color.Black), RoundedCornerShape(10.dp)),
            textStyle = TextStyle(
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        )

        Button(
            onClick = {
                val note = Note(
                    title = title.value,
                    description = description.value,
                    datetime = getDateTime.execute()
                )

                db.noteDAO().addNote(
                    note = note
                )
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "Создать заметку",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}
