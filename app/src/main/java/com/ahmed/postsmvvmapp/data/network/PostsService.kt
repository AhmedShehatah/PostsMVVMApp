package com.ahmed.postsmvvmapp.data.network

import com.ahmed.postsmvvmapp.data.model.PostModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PostsService {
    @GET("posts")
    fun getPosts(): Call<List<PostModel>>

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        operator fun invoke(): PostsService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PostsService::class.java)
        }
    }
}