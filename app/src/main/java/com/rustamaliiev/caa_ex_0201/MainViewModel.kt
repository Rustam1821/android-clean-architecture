package com.rustamaliiev.caa_ex_0201

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(
    private val userService: UserService,
    private val dao: UserDao,
) : ViewModel() {

    var resultState by mutableStateOf<List<RoomUser>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            flow {
                emit(userService.getUsers())
            }.onEach {
                val roomUsers = it.map { user ->
                    RoomUser(
                        id = user.id,
                        name = user.name,
                        username = user.username,
                        email = user.email,
                    )
                }
                dao.insertUsers(roomUsers)
            }.flatMapConcat {
                dao.getUsers()
            }.catch {
                emitAll(dao.getUsers())
            }.flowOn(Dispatchers.IO)
                .collect {
                    resultState = it
                }
        }
    }
}

class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        MainViewModel(
            userService = MyApplication.userService,
            dao = MyApplication.userDao,
        ) as T
}