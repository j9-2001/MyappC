package com.example.cweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cweek04a.model.TodoItemFactory

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val todoList = remember {
        // mutableStateListOf<Item>() : 빈 리스트를 의미
        TodoItemFactory.makeTodoList()
    }
    Column( modifier = Modifier.fillMaxWidth()) {
        TodoListTitle(modifier = Modifier.padding(15.dp))
        TodoList(todoList = todoList, modifier = Modifier.weight(1f))
        TodoItemInput(todoList = todoList, modifier = Modifier.padding(15.dp))
    }

}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}