package com.example.quicknotes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(notes: List<Note>, onEditNote: (String,String,String) -> Unit){
    LazyColumn {
        items(notes) {note ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onEditNote(note.id.toString(), note.title, note.content) },

            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = note.title, style = MaterialTheme.typography.titleLarge)
                    Text(
                        text = note.content,
                        maxLines = 1,
                        style = MaterialTheme.typography.bodyLarge,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

