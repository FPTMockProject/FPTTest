package com.example.apptest.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun App(
    appViewModel: AppViewModel = hiltViewModel(),
) {
    var location by remember {
        mutableStateOf("55N")
    }
    var locationError by remember {
        mutableStateOf("")
    }
    var instruction by remember {
        mutableStateOf("MMRMMLLMRMLLM")
    }
    var instructionError by remember {
        mutableStateOf("")
    }
    val onSubmitPressed by rememberUpdatedState {
        locationError = ""
        instructionError = ""
        if (location.isEmpty()) {
            locationError = "Required field is empty"
        }
        if (instruction.isEmpty()) {
            instructionError = "Required field is empty"
        }
        appViewModel.onSubmitPressed(location, instruction)
    }
    val state by appViewModel.uiState.collectAsState()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "NASA"
                        )
                    }
                )
            },
        ) { contentPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(contentPadding)
                    .padding(horizontal = 10.dp)
                    .consumeWindowInsets(contentPadding),
            ) {
                TextField(
                    value = location,
                    onValueChange = { value -> location = value },
                    label = {
                        Text(
                            text = "Location"
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Input your location coordinate"
                        )
                    },
                    isError = locationError.isNotEmpty(),
                )
                if (locationError.isNotEmpty()) {
                    Text(
                        text = locationError,
                        color = Color.Red
                    )
                }
                Spacer(
                    modifier = Modifier.height(10.dp),
                )
                TextField(
                    value = instruction,
                    onValueChange = { value -> instruction = value },
                    label = {
                        Text(
                            text = "Instruction"
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Input your instruction"
                        )
                    },
                    isError = instructionError.isNotEmpty(),
                )
                if (instructionError.isNotEmpty()) {
                    Text(
                        text = instructionError,
                        color = Color.Red
                    )
                }
                Spacer(
                    modifier = Modifier.height(10.dp),
                )
                ElevatedButton(
                    onClick = onSubmitPressed
                ) {
                    Text(
                        text = "Submit"
                    )
                }
                Spacer(
                    modifier = Modifier.height(10.dp),
                )
                Text(
                    text = "Output: ${state.output}",
                    style = MaterialTheme.typography.headlineMedium,
                )
            }
        }
    }
}