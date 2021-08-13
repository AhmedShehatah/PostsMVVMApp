package com.ahmed.postsmvvmapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ahmed.postsmvvmapp.R
import com.ahmed.postsmvvmapp.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var postsViewModel: PostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postsViewModel = ViewModelProvider(this).get(PostViewModel::class.java)
        val recyclerView: RecyclerView = findViewById(R.id.recycler1)
        recyclerView.layoutManager = LinearLayoutManager(this)
        postsViewModel.postMutableLiveData.observe(this,
            { postModel ->
                recyclerView.adapter = PostsAdapter(postModel)
            })

        postsViewModel.getPost()
    }
}