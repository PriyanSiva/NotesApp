package com.spr.notesapp.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.spr.notesapp.model.Note
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier

@Composable
fun NotesList(notes: List<Note>, onDelete: (Note) -> Unit) {
    if (notes.isEmpty()) {
        Text("No notes yet. Add one above!")
    } else {
        LazyColumn {
            items(notes) { note ->
                NoteCard(note = note, onDelete = onDelete)
            }
        }
    }
}
