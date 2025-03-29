package com.example.cweek04a.model

import com.example.cweek04a.model.TodoStatus

data class Item(
    val content: String,
    val time: String,
    var status: TodoStatus = TodoStatus.PENDING
)