package me.lokmvne.app2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import me.lokmvne.app2.ui.theme.App2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App2Theme {
                val visibleState = remember { MutableTransitionState(true) }
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFF252525)),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    AnimatedVisibility(visibleState = visibleState) {
                        Image(
                            painter = painterResource(id = R.drawable.sheilddd),
                            contentDescription = "at",
                            modifier = Modifier.size(250.dp)
                        )
                    }
                }

            }

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeAlertDialogue(
    title: String,
    onTimeSet: () -> Unit,
    onDismiss: () -> Unit,
    timePickerState: TimePickerState
) {
    AlertDialog(
        modifier = Modifier
            .height(550.dp),
        title = { Text(text = title) },
        text = { MyTimePicker(timePickerState) },
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Button(onClick = {
                onTimeSet()
                onDismiss()
            }) {
                Text(text = "OK")
            }
        },
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
        )

    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTimePicker(timePickerState: TimePickerState) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TimePicker(
            state = timePickerState
        )
    }

}

