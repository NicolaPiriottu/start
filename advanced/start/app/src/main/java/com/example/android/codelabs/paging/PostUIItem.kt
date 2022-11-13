package com.example.android.codelabs.paging


sealed class PostUIItem(val type: Type) {

    enum class Type {
        HEADER,
        POST
    }

    data class Header(
        val title: String,
    ) : PostUIItem(Type.HEADER)

    data class RepoUIItem(
        val id: Long,
        val name: String,
        val fullName: String,
        val description: String?,
        val url: String,
        val stars: Int,
        val forks: Int,
        val language: String?,
    ) : PostUIItem(Type.POST)
}
