package com.company.room_implementation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.company.room_implementation.component.EmployeeScreen
import com.company.room_implementation.ui.theme.Room_ImplementationTheme

class MainActivity : ComponentActivity() {
    private val viewModel: RoomViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            viewModel.initializeRoomDataBase(this)
            Room_ImplementationTheme {
                val employees = viewModel.getEmployee()?.collectAsStateWithLifecycle(emptyList())
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EmployeeScreen(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        employeeList = employees?.value ?: emptyList(),
                        onSave = { name, age ->
                            viewModel.save(name, age)
                        },
                        onUpdate = { id, name, age ->
                            viewModel.update(id, name, age)
                        },
                        onDelete = { id ->
                            viewModel.delete(id)
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Room_ImplementationTheme {
        EmployeeScreen()
    }
}