package will.shiro.composelabs1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import will.shiro.composelabs1.ui.theme.Composelabs1Theme
import will.shiro.composelabs1.ui.theme.PrimaryH4
import kotlin.math.exp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Composelabs1Theme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    LazyColumn {
        items(List(200) { it }) {
            Item(it)
        }
    }
}

@Composable
fun Item(number: Int) {
    Card(backgroundColor = MaterialTheme.colors.primary, modifier = Modifier.padding(16.dp)) {
        ItemContent(number)
    }
}

@Composable
fun ItemContent(number: Int) {
    val expanded = remember { mutableStateOf(false) }

    Column(Modifier.padding(16.dp).animateContentSize()) {
        Row {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = stringResource(id = R.string.hello))
                Text(text = number.toString(), style = MaterialTheme.typography.h4)
            }
            IconButton(onClick = { expanded.value = !expanded.value }) {
                Icon(
                    imageVector = if (expanded.value) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (expanded.value) stringResource(R.string.show_less) else stringResource(R.string.show_more)
                )
            }
        }
        if (expanded.value) {
            Text(text = stringResource(R.string.long_text))
        }
    }
}