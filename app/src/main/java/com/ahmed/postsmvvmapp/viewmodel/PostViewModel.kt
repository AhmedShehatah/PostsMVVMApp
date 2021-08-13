package com.ahmed.postsmvvmapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmed.postsmvvmapp.data.model.PostModel
import com.ahmed.postsmvvmapp.data.network.PostsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {
    var postMutableLiveData = MutableLiveData<List<PostModel>>()
    fun getPost() {
        PostsService.invoke().getPosts().enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                postMutableLiveData.value = response.body()!!
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {

            }
        })
    }
}