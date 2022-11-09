package com.rustamaliiev.caa_ex_0201

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Calculator(
    a: String,
    onAChanged: (String) -> Unit,
    b: String,
    onBChanged: (String) -> Unit,
    result: String,
    onButtonClick: () -> Unit,
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        OutlinedTextField(
            value = a,
            onValueChange = onAChanged,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
            ),
            label = { Text(text = "a")}
        )
        OutlinedTextField(
            value = b, 
            onValueChange = onBChanged,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
            ),
            label = { Text(text = "b")}
        )
        Text(text = result)
        Button(onClick = onButtonClick) {
            Text(text = "Click to calculate")
        }
    }
}