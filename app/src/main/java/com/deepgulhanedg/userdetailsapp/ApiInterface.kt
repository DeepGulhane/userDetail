package com.deepgulhanedg.userdetailsapp

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET(value = "/api/users?page=2")
    fun getData(): Call<List<Data>>
}