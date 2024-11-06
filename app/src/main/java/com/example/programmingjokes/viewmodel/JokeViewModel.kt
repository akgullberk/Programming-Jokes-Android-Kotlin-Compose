package com.example.programmingjokes.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.programmingjokes.model.Joke
import com.example.programmingjokes.service.JokeAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JokeViewModel : ViewModel() {

    private val BASE_URL = "https://raw.githubusercontent.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(JokeAPI::class.java)

    val jokeList = mutableStateOf<List<Joke>>(listOf())

    init {
        getJokes()
    }

    private fun getJokes(){
        viewModelScope.launch(Dispatchers.IO){
           jokeList.value =  retrofit.getData()
        }
    }
}