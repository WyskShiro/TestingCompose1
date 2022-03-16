package will.shiro.composelabs1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import will.shiro.composelabs1.ui.theme.Composelabs1Theme

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

    ConstraintLayout(
        Modifier
            .padding(16.dp)
            .animateContentSize()
            .fillMaxWidth()
    ) {
        val (helloText, numberText, iconButton, longText) = createRefs()

        Text(
            modifier = Modifier.constrainAs(helloText) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
            },
            text = stringResource(id = R.string.hello)
        )

        Text(
            modifier = Modifier.constrainAs(numberText) {
                top.linkTo(helloText.bottom)
                start.linkTo(parent.start)
            },
            text = number.toString(), style = MaterialTheme.typography.h4
        )

        IconButton(
            modifier = Modifier.constrainAs(iconButton) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
            },
            onClick = { expanded.value = !expanded.value }
        ) {
            Icon(
                imageVector = if (expanded.value) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded.value) stringResource(R.string.show_less) else stringResource(R.string.show_more)
            )
        }
        if (expanded.value) {
            Text(
                modifier = Modifier.constrainAs(longText) {
                    top.linkTo(numberText.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                },
                text = stringResource(R.string.long_text)
            )
        }
    }
}