package com.example.scafoldexample

import android.annotation.SuppressLint
import android.graphics.BlendModeColorFilter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.scafoldexample.ui.theme.ScafoldExampleTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScafoldExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyScaffold()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyScaffold() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        contentColor = Color.Blue,
        content = { MyRow() },
        topBar = { MyTopAppBar(scaffoldState = scaffoldState,
            scope = scope) },
        bottomBar = { MyBottomAppBar() },
        drawerContent = { MyColumn() }
    )

        }

@Composable
fun MyRow()

{
    Row(modifier = Modifier.fillMaxSize(),
    verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround

        ) {
        Text(text = "First")
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Second")
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Third")
    }

}
@Composable
fun MyColumn(){
    Column(modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
        ) {
        Text(text = "First")
        Text(text = "Second")
        Text(text = "Third")
    }

}

@Composable
fun MyTopAppBar(scaffoldState: ScaffoldState, scope:
CoroutineScope){
val drawerState = scaffoldState.drawerState
TopAppBar(navigationIcon = {
    IconButton(
        content = {
            Icon(
                Icons.Default.Menu,
                tint = Color.White,
                contentDescription = ""
            )
        },
        onClick = {
            scope.launch { if (drawerState.isClosed)
                drawerState.open() else drawerState.close() }
        }
    )
},
    title = { Text(text = stringResource(id =
    R.string.app_name), color = Color.White) },
    backgroundColor = Color.Green
)
}
@Composable
fun MyBottomAppBar(){
    BottomAppBar(
        content = {},
        backgroundColor =Color.Green)

        }

fun Icon(call: ImageVector) {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ScafoldExampleTheme {
        MyScaffold()
    }
}