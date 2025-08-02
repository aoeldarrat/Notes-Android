package com.app.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.notes.ui.theme.NotesTheme
import kotlinx.serialization.Serializable

// Dependency injection - dont need right now
//        val appModule = module {
//            singleOf(::NoteRepositoryImpl) { bind<NoteRepository>() }
//            viewModelOf(::NotesViewModel)
//        }
//
//        startKoin {
//            // inject Android context
//            androidContext(this@MainActivity)
//            modules(appModule)
//        }


/**
 * Routes to navigate to
 */
@Serializable
object Home

@Serializable
object NoteCreation

class MainActivity : ComponentActivity() {

    // TODO setup navigation to another fragment
    // TODO setup room database or another local database for notes
    // Dependency injection is on pause

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NotesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = Home
                    ) {
                        composable<Home> {
                            HomeScreen {
                                navController.navigate(route = NoteCreation)
                            }
                        }

                        composable<NoteCreation> {
                            NoteCreateScreen()
                        }
                    }
                }
            }
        }
    }


}

@Composable
fun HomeScreen(
    onCreateNote: () -> Unit
) {
    val addButtonEnabled = remember { mutableStateOf(true) }
    Column {
        // Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // TODO add search bar
//            SearchBar(inputField = { SearchTextField() }) { }

            Button(
                onClick = onCreateNote,
                enabled = addButtonEnabled.value,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.Black
                ),
                border = ButtonDefaults.outlinedButtonBorder(),
            ) {
                Text("Add note")
            }
        }

        // List of notes
        LazyColumn {
            item {
                Text("Note x")
            }
        }
    }
}


@Composable
fun NoteCreateScreen() {
    // TODO Note creation screen

    Text(text = "Hello!",)
}