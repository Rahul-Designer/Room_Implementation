package com.company.room_implementation.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EmployeeEntity")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val age: Int,
    @ColumnInfo(name = "salary", defaultValue = "")
    val salary: Int
)
@Entity(tableName = "EmployeeSalaryEntity")
data class EmployeeSalary(
    val name: String,
    val salary: Int
)


@Entity(tableName = "ClientEntity")
data class ClientDetail(
    val name: String,
    val age: Int,
    val salary: Int
)