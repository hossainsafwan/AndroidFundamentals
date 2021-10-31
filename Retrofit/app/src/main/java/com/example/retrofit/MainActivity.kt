package com.example.retrofit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "MainActivity-Response"
private const val BASE_URL = "https://api.github.com/"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repoList = mutableListOf<Repos>()
        val adapter = RepositoriesAdapter(this, repoList)
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        val githubService = retrofit.create(GithubService::class.java)

        rvRepositories.adapter = adapter
        rvRepositories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //This call is not immediate since this is a network call
        //Cannot hold the main thread or the UI thread because this operation is not immediate
        val repos = githubService.searchRepositories("org:square", "stars", "desc", 3).enqueue(object : Callback<SearchRepoDataClass> {
                @SuppressLint("NotifyDataSetChanged")
                override fun onResponse(call: Call<SearchRepoDataClass>, response: Response<SearchRepoDataClass>) {
                    Log.d(TAG, "$response")
                    val body = response.body()
                    if (body == null) Log.d(TAG, "Something went wrong!")
                    else repoList.addAll(body.items)
                    adapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<SearchRepoDataClass>, t: Throwable) {
                    Log.d(TAG, "$t")
                }

            })

    }
}