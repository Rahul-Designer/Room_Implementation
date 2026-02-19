package com.company.room_implementation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.company.room_implementation.model.Employee

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeeScreen(
    modifier: Modifier = Modifier,
    employeeList: List<Employee> = emptyList(),
    onDelete: (Int) -> Unit = {},
    onSave: (String, Int) -> Unit = { _, _ -> },
    onUpdate: (Int, String, Int) -> Unit = { _, _, _ -> }
) {
    var name by rememberSaveable() { mutableStateOf("") }
    var age by rememberSaveable() { mutableStateOf("") }
    var id by rememberSaveable() { mutableStateOf("") }
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        TopAppBar(title = { Text(text = "Room Database") })
    }) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Column(modifier = Modifier) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    OutlinedTextField(value = name, onValueChange = {
                        name = it
                    }, modifier = Modifier.fillMaxWidth(), label = {
                        Text(text = "Enter your name..")
                    }, singleLine = true)
                    OutlinedTextField(
                        value = age,
                        onValueChange = {
                            age = it
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(text = "Enter your age...")
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    OutlinedTextField(
                        value = id,
                        onValueChange = {
                            id = it
                        },
                        modifier = Modifier.fillMaxWidth(),
                        label = {
                            Text(text = "Enter your id to update the employee info")
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Button(onClick = {
                            if (name.isNotBlank() && age.isNotBlank()) {
                                onSave(name, age.toInt())
                                name = ""
                                age = ""
                                id = ""
                            }
                        }) {
                            Text(text = "Save Employee")
                        }
                        Button(onClick = {
                            if (id.isNotBlank() && name.isNotBlank() && age.isNotBlank()) {
                                onUpdate(id.toInt(), name, age.toInt())
                                name = ""
                                age = ""
                                id = ""
                            }
                        }) {
                            Text(text = "Update Employee")
                        }
                    }
                }
                if (employeeList.isNotEmpty()) {
                    Column(modifier = Modifier.weight(1f)) {
                        EmployeeList(
                            modifier = Modifier,
                            employeeList = employeeList,
                            onDelete = {
                                onDelete.invoke(it)
                            }
                        )
                    }
                }
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun EmployeeScreenPreview(modifier: Modifier = Modifier) {
    EmployeeScreen()
}