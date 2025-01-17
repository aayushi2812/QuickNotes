package com.example.quicknotes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quicknotes.ui.theme.QuickNotesTheme

@Composable
fun CreateNoteScreen(noteId: String? = null, noteTitle: String? = "", noteContent: String? = "",
                     onSaveNote: (String, String) -> Unit, onBack: () -> Unit,
                     onDelete: () -> Unit){
    var title by remember { mutableStateOf(noteTitle) }
    var content by remember { mutableStateOf(noteContent) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = title.toString(),
            onValueChange = { title = it },
            label = { Text("Title") }
        )
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = content.toString(),
            onValueChange = { content = it },
            label = { Text("Content") }
        )
        Row (modifier = Modifier.fillMaxWidth()
            .align(Alignment.CenterHorizontally)) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    containerColor = Color(0xFFD99D81),
                ),
                modifier = Modifier.weight(1f).padding(4.dp),
                onClick = {
                    onSaveNote(title.toString(), content.toString())
                },

                ) {
                Text("Save")
            }
            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    containerColor = Color(0xFFD99D81),
                ),
                modifier = Modifier.weight(1f).padding(4.dp),
                onClick = {
                    onBack()
                },

                ) {
                Text("Cancel")
            }
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color(0xFFD99D81),
            ),
            modifier = Modifier.fillMaxWidth()
            ,
            onClick = {
                if (noteId != null) {
                    onDelete()
                }
            },

            ) {
            Text("Delete")
        }
    }
}
