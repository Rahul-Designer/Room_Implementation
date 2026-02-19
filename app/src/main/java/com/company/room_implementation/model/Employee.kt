package com.company.room_implementation.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EmployeeEntity")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val name : String,
    val age : Int
)