package com.example.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_repo.view.*

class RepositoriesAdapter(private val context: Context, private val repoList: List<Repos>) :
    RecyclerView.Adapter<RepositoriesAdapter.ViewHolder>() {


    //Inflate a new layout and wrap that inside a viewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_repo, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val repo = repoList[position]
        holder.bind(repo)
    }

    override fun getItemCount() = repoList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(repo: Repos) {
            itemView.itemName.text = repo.name
        }
    }

}
