package com.ubaya.todoapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    @ColumnInfo(name="title")
    var title:String,
    @ColumnInfo(name="notes")
    var notes:String,
    @ColumnInfo(name="priority")
    var priority:Int,
    @ColumnInfo(name="is_done") //karena kalau pake integer bisa ditambahi pengecekan jadi tidak hanya 2 seperti boolean, yg hny true or false tapi klo pake integer kita bisa memakai angka lain untuk mengecek. 
    var is_done:Int = 0
) {
    @PrimaryKey(autoGenerate = true)
    var uuid: Int = 0

}
