package com.ubaya.todoapp.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

    @Dao
    interface TodoDao {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertAll(vararg todo:Todo)

        @Query("SELECT * FROM todo WHERE is_done = 0 ORDER BY priority DESC")
        fun selectAllTodo(): List<Todo>

        @Query("SELECT * FROM todo WHERE uuid= :id")
        fun selectTodo(id:Int): Todo

        @Query("UPDATE todo SET title=:title, notes=:notes, priority=:priority WHERE uuid = :id")
        fun update(title:String, notes:String, priority:Int, id:Int) //ini harus dijalankan setelah database dimigrasi. baru bole update habis migrasi gitu itu gunanya suspend

        @Query("UPDATE todo SET is_done = 1 WHERE uuid = :id")
        fun markTodoAsDone(id: Int)

        @Delete
        fun deleteTodo(todo:Todo)
    }

