package com.spr.notesapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.spr.notesapp.viewmodel.NoteViewModel

@Composable
fun NoteInputForm(viewModel: NoteViewModel) {

    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        // Title field
        OutlinedTextField(
            value = viewModel.title.value,
            onValueChange = {
                viewModel.title.value = it
                showError = false
            },
            label = { Text("Title") },
            isError = showError && viewModel.title.value.isBlank(),
            modifier = Modifier.fillMaxWidth()
        )

        // Description field
        OutlinedTextField(
            value = viewModel.description.value,
            onValueChange = {
                viewModel.description.value = it
                showError = false
            },
            label = { Text("Description") },
            isError = showError && viewModel.description.value.isBlank(),
            modifier = Modifier.fillMaxWidth(),
            minLines = 3
        )

        // Error message
        if (showError) {
            Text(
                text = "Title and description cannot be empty",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        // Save button
        Button(
            onClick = {
                if (viewModel.title.value.isBlank() || viewModel.description.value.isBlank()) {
                    showError = true
                } else {
                    viewModel.addNote()
                    showError = false
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save Note")
        }
    }
}