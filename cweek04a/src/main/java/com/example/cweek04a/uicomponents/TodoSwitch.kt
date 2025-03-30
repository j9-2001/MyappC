package com.example.cweek04a.uicomponets

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TodoSwitch(
    statuscomplete: Boolean,
    onToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(text = "미완료 항목만 보기")
        Spacer(modifier = Modifier.width(8.dp))
        Switch(checked = statuscomplete, onCheckedChange = onToggle)
    }
}

@Preview(showBackground = true)
@Composable
fun TodoSwitchPreview() {
    TodoSwitch(statuscomplete = false, onToggle = {})
}