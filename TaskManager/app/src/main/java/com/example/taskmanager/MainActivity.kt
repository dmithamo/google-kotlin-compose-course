package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TaskManagerLayout(
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(color = MaterialTheme.colorScheme.background)
                    )
                }
            }
        }
    }
}

@Composable
fun TaskManagerLayout(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxHeight().fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_task_completed),
            contentDescription = null,
            modifier = modifier
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
            Text(
                text = stringResource(R.string.all_tasks_completed),
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(top = 24.dp, bottom = 8.dp)
            )
            Text(
                text = stringResource(R.string.nice_work), fontSize = 16.sp, modifier = modifier
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TaskManagerLayoutPreview() {
    TaskManagerTheme {
        TaskManagerLayout()
    }
}