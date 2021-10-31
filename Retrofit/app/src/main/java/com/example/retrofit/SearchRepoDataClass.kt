package com.example.retrofit

import com.google.gson.annotations.SerializedName

data class SearchRepoDataClass(
    val items: List<Repos>
)

data class Repos(
    val name: String,
    @SerializedName("html_url") val htmlUrl: String,
    @SerializedName("stargazers_count") val stars: Int
)
