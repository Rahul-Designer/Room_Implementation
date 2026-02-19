package com.company.room_implementation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.company.room_implementation.local.AppDatabase
import com.company.room_implementation.local.EmployeeDao
import com.company.room_implementation.model.Employee
import kotlinx.coroutines.launch

class RoomViewModel : ViewModel() {

    private var dao: EmployeeDao? = null

    fun initializeRoomDataBase(context: Context) {
        val db = AppDatabase.getInstance(context)
        dao = db.getEmployeeDao()
    }

    fun save(name: String, age: Int,salary : Int) = viewModelScope.launch {
        val employee = Employee(name = name, age = age, salary = salary)
        dao?.save(employee)
    }

    fun update(id: Int, name: String, age: Int,salary: Int) = viewModelScope.launch {
        val employee = Employee(id = id, name = name, age = age,salary = salary)
        dao?.update(employee)
    }

    fun delete(id: Int) = viewModelScope.launch {
        dao?.delete(id)
    }

    fun getEmployee() = dao?.getAllEmployee()

}