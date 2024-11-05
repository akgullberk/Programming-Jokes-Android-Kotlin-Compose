package com.example.programmingjokes.service

import com.example.programmingjokes.model.Joke
import retrofit2.http.GET

interface JokeAPI {

    @GET("atilsamancioglu/ProgrammingJokesJSON/refs/heads/main/jokes.json")
    suspend fun getData() : List<Joke>
}