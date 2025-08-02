package com.app.notes

import androidx.lifecycle.ViewModel
import com.app.notes.model.Note

class NotesViewModel: ViewModel() {

   // Do the stuff
}

interface NoteRepository {
    fun findNote(id : String): Note?
    fun addNotes(notes : List<Note>)
}

class NoteRepositoryImpl : NoteRepository {

    private val _notes = arrayListOf<Note>()

    override fun findNote(id: String): Note? {
        return _notes.firstOrNull { it.id == id }
    }

    override fun addNotes(notes : List<Note>) {
        _notes.addAll(notes)
    }
}