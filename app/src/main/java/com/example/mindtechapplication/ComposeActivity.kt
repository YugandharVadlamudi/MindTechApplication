package com.example.mindtechapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mindtechapplication.ui.theme.MindTechApplicationTheme

class ComposeActivity : ComponentActivity() {
    lateinit var dotSelectionState: MutableState<Boolean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MindTechApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
//                    Greeting("Android")
                    ViewPagerCompose()
                }
                dotSelectionState = remember { mutableStateOf(false) }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MindTechApplicationTheme {
        Greeting("Android")
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ViewPagerCompose() {
    val pagerState = rememberPagerState()
    val textFieldState = remember { mutableStateOf(11) }
    var dotSelectionState = remember { mutableStateOf(false) }
    Column() {
        Box(
            modifier = Modifier
                .background(Color.Red),

        ) {
            HorizontalPager(
                pageCount = 2,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp),
                state = pagerState,
            ) {
                Image(painter = painterResource(id = R.drawable.on), contentDescription = null, modifier = Modifier.fillMaxSize())
                if (pagerState.currentPage == 0) {
                    dotSelectionState.value = true
                } else {
                    dotSelectionState.value = false
                }
            }
            Row(
                verticalAlignment = Alignment.Bottom,
                modifier = Modifier
                    .align(Alignment.BottomCenter),

            ) {
                Box(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .background(if (dotSelectionState.value) Color.Black else Color.Gray)
                        .height(10.dp)
                        .width(10.dp),

                )
                Box(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .background(if (!dotSelectionState.value) Color.Black else Color.Gray)
                        .height(10.dp)
                        .width(10.dp),

                )
            }
        }
        Box(modifier = Modifier.fillMaxWidth().heightIn(30.dp).background(Color.Blue)) {
            TextField(value = textFieldState.value.toString(), onValueChange = { value ->
                if (value.isEmpty()) {
                    textFieldState.value = 11
                } else {
                    textFieldState.value = value.toInt()
                }
            }, modifier = Modifier.fillMaxWidth(), placeholder = { Text(text = "Hello") })
        }
        LazyCompose(Modifier.align(Alignment.CenterHorizontally), textFieldState)
    } // Column
}

/**
 * Lazy Compose
 */
@Composable
fun LazyCompose(check: Modifier, textFieldState: MutableState<Int>) {
    var arrayListOf = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)

    if (arrayListOf.contains(textFieldState.value)) {
        arrayListOf.clear()
        arrayListOf.add(textFieldState.value)
    } else {
        arrayListOf = arrayListOf
    }

    LazyColumn(modifier = check) {
        items(arrayListOf, itemContent = {
            Text(text = it.toString(), fontSize = 30.sp, modifier = Modifier.fillMaxWidth())
        })
    }
}
