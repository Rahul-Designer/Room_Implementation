package com.company.room_implementation.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EmployeeEntity")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val name : String,
    val age : Int,
    @ColumnInfo(name = "salary", defaultValue = "")
    val salary : Int
)

@Entity(tableName = "EmployeeExpanses")
data class EmployeeExpanses(
    val id : Int,
    val expansePrice : Double,
    val expanseList : List<String>
)