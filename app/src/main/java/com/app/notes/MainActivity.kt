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
import com.app.notes.ui.theme.NotesTheme
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

class MainActivity : ComponentActivity() {

    // TODO setup navigation to another fragment
    // TODO setup room database or another local database for notes
    // Dependency injection is on pause

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        enableEdgeToEdge()
        setContent {
            val addButtonEnabled = remember { mutableStateOf(true) }

            NotesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        // Header
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Search bar here")
//                            SearchBar(inputField = {
//                                TextField()
//                            }) { }

                            // Add note button

                            Button(
                                onClick = {
                                    // Handle button click
                                },
                                enabled = addButtonEnabled.value,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White,
                                    contentColor = Color.Black,
                                    disabledContainerColor = Color.Gray,
                                    disabledContentColor = Color.Black
                                ),
                                border = ButtonDefaults.outlinedButtonBorder(),
                                contentPadding = innerPadding,
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
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NotesTheme {
        Greeting("Android")
    }
}