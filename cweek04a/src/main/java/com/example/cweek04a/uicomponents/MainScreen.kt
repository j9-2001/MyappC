package com.example.cweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cweek04a.model.TodoItemFactory
import com.example.cweek04a.model.TodoStatus
import com.example.cweek04a.uicomponets.TodoSwitch

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val todoList = remember {
        TodoItemFactory.makeTodoList()
    }
    val showIncompleteOnly = remember { mutableStateOf(false) }
    val displayedTodoList = if (showIncompleteOnly.value) {
        todoList.filter { it.status == TodoStatus.PENDING }
    } else {
        todoList
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        TodoListTitle(modifier = Modifier.padding(50.dp))
        TodoSwitch(
            statuscomplete = showIncompleteOnly.value,
            onToggle = { checked -> showIncompleteOnly.value = checked },
            modifier = Modifier.padding(10.dp)
        )
        TodoList(
            items = displayedTodoList,
            onItemCheckedChange = { item, checked ->
                val index = todoList.indexOf(item)
                if (index != -1) {
                    todoList[index] = item.copy(
                        status = if (checked) TodoStatus.COMPLETED else TodoStatus.PENDING
                    )
                }
            },
            modifier = Modifier.weight(1f)
        )
        TodoItemInput(todoList = todoList, modifier = Modifier.padding(15.dp))
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}
