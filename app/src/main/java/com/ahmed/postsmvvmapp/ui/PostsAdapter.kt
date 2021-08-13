package com.ahmed.postsmvvmapp.ui
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmed.postsmvvmapp.data.model.PostModel
import com.ahmed.postsmvvmapp.databinding.ActivityMainBinding.inflate


class PostsAdapter(private val list: List<PostModel>) :
    RecyclerView.Adapter<PostsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bind = com.ahmed.postsmvvmapp.databinding.ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(bind)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]


    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(private val binding: com.ahmed.postsmvvmapp.databinding.ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}

