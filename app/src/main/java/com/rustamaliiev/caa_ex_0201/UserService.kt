package com.rustamaliiev.caa_ex_0201

import retrofit2.http.GET

interface UserService {

    @GET("/users")
    suspend fun getUsers(): List<User>

}