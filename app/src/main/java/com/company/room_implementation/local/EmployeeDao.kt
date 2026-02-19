package com.company.room_implementation.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.company.room_implementation.model.Employee
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(employee: Employee)

    @Update
    suspend fun update(employee: Employee)

    @Query("DELETE FROM EMPLOYEEENTITY WHERE id = :id")
    suspend fun delete(id : Int)

    @Query("SELECT * FROM EMPLOYEEENTITY")
    fun getAllEmployee () : Flow<List<Employee>>

}