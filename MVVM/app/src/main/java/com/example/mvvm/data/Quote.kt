package com.example.mvvm.data
/*
* Data class:
* */
data class Quote(val quoteText: String, val author: String) {

    override fun toString(): String {
        return "$quoteText - $author"
    }
}