package com.rustamaliiev.caa_ex_0201

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Screen(viewModel: MainViewModel = viewModel(factory = MainViewModelFactory())) {
    UserList(users = viewModel.resultState)
}

@Composable
fun UserList(
    users: List<RoomUser>
) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(users) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(it.name)
                Text(it.username)
                Text(it.email)
            }
        }
    }
}