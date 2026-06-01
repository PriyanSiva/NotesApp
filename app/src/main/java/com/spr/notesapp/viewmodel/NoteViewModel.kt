package com.spr.notesapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.spr.notesapp.model.Note

class NoteViewModel : ViewModel() {

    // State - Notes List
    val notes = mutableStateListOf<Note>()


    // State - Input fields
    var title = mutableStateOf("")
    var description = mutableStateOf("")

    // Add a note
    fun addNote() {
        if (title.value.isBlank() || description.value.isBlank()) return

        val newNote = Note(
            id = notes.size + 1,
            title = title.value.trim(),
            description = description.value.trim()
        )

        notes.add(newNote)

        // Clear inputs after saving
        title.value = ""
        description.value = ""


    }
    // Delete a note
    fun deleteNote(note: Note) {
        notes.remove(note)
    }
}