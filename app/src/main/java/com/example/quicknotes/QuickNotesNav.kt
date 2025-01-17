package com.example.quicknotes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.navArgument

@Composable
fun QuickNotesNav(navHostController: NavHostController){

    val notes = remember { mutableStateListOf<Note>() }
    var id = 2 ;
    notes.add(Note(1,"First", "Content 1"))
    notes.add(Note(2,"Second", "Content 2"))
    var editId = 0;

    NavHost(navHostController,
        startDestination = "home") {

        composable(route = "home") { HomeScreen(
            notes = notes
        ) { noteID,noteTitle,noteContent ->
            System.out.println("edit mode")
            System.out.println(noteID)
            editId = noteID.toInt()
            navHostController.navigate("note/$noteID?title=${noteTitle}&content=${noteContent}")
        }
        }
        composable(route = "create") { CreateNoteScreen(
            onSaveNote = { title, content ->
                notes.add(Note(++id, title, content))
                navHostController.popBackStack()
            },
            onBack = { navHostController.popBackStack() },
            onDelete = { navHostController.popBackStack() }
        ) }

        composable(
            "note/{noteId}?title={title}&content={content}",
            arguments = listOf(
                navArgument("noteId") { type = NavType.StringType },
                navArgument("title") { type = NavType.StringType; defaultValue = "" },
                navArgument("content") { type = NavType.StringType; defaultValue = "" }
            )
        ) { backStackEntry ->
            val noteId = backStackEntry.arguments?.getString("noteId")
            val noteTitle = backStackEntry.arguments?.getString("title") ?: ""
            val noteContent = backStackEntry.arguments?.getString("content") ?: ""

            CreateNoteScreen(
                noteId = noteId,
                noteTitle = noteTitle,
                noteContent = noteContent,
                onSaveNote = { title, content ->
                    for (note in notes) {
                        if (note.id == editId) {
                            note.title = title
                            note.content = content
                        }
                    }
                    navHostController.popBackStack()
                },
                onBack = { navHostController.popBackStack() },
                onDelete = {
                    notes.removeAt(editId-1)
                    navHostController.popBackStack()
                }
            )
        }

    }
}
