package com.company.room_implementation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(modifier = Modifier) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) { }
    }
}