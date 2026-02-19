package com.company.room_implementation.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.company.room_implementation.migration.MIGRATION_1_2
import com.company.room_implementation.model.Employee

@Database(entities = [Employee::class], version = 2, exportSchema = false)
abstract class AppDatabase() : RoomDatabase() {
    companion object {
        fun getInstance(context : Context) : AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "app_database"
            ).addMigrations(
                MIGRATION_1_2
            )
                .build()
        }
    }
    abstract fun getEmployeeDao() : EmployeeDao
}