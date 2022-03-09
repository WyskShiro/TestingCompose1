package will.shiro.composelabs1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import will.shiro.composelabs1.ui.theme.Composelabs1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Composelabs1Theme {
                Greeting("Android")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Column(modifier = Modifier.padding(24.dp)) {
        WordLine(text = "aaaaaa")
        WordLine(text = "bbbbbb")
    }
}

@Composable
fun WordLine(text: String) {
    val expanded = remember { mutableStateOf(false) }
    Surface(
        color = MaterialTheme.colors.primary, modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = 24.dp,
                vertical = if (expanded.value) 30.dp else 10.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = text)
            }
            OutlinedButton(onClick = { expanded.value = !expanded.value }) {
                Text(text = if (expanded.value) "expanded" else "not expanded")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    Composelabs1Theme {
        Greeting("Android")
    }
}