package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("search/repositories")
    fun searchRepositories(
        @Query("q") org: String,
        @Query("sort") sort: String,
        @Query("order") order: String,
        @Query("per_page") perPage: Int
    ): Call<SearchRepoDataClass>
}