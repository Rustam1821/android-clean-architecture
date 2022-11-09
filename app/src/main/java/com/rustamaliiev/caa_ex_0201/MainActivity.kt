package com.rustamaliiev.caa_ex_0201

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rustamaliiev.caa_ex_0201.ui.theme.CAA_ex_0201Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CAA_ex_0201Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Screen()
                }
            }
        }
    }

}

@Composable
fun Screen(
    viewModel: MainViewModel = viewModel()
) {
    var a by remember {
        mutableStateOf("")
    }

    var b by remember {
        mutableStateOf("")
    }

    Calculator(
        a = a,
        onAChanged = { a = it },
        b = b,
        onBChanged = { b = it },
        result = viewModel.resultState,
        onButtonClick = {
            viewModel.add(a, b)
        }
    )
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CAA_ex_0201Theme {
        Greeting("Android")
    }
}