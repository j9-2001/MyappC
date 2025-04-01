package com.example.cweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cweek04a.model.Item

@Composable
fun TodoList(
    items: List<Item>,
    onItemCheckedChange: (item: Item, checked: Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .verticalScroll(state = scrollState)
    ) {
        items.forEach { item ->
            Card(modifier = Modifier.fillMaxWidth()) {
                androidx.compose.foundation.layout.Row {
                    TodoCheckbox(checked = item.status.name == "COMPLETED") { checked ->
                        onItemCheckedChange(item, checked)
                    }
                    TodoItem(item = item)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
