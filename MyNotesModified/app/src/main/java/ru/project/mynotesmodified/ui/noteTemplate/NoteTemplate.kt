package ru.project.mynotesmodified.ui.noteTemplate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.project.mynotesmodified.domain.models.Note

@Composable
fun NoteTemplate(note: Note) {
    Card(
        modifier = Modifier.
            background(Color.White)
            .fillMaxWidth()
            .padding(5.dp)

        ,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = "Название:",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                text = note.title,
                fontSize = 25.sp
            )
            Text(
                text = "Описание:",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            Text(
                text = note.description,
                fontSize = 25.sp
            )

        }
    }
}