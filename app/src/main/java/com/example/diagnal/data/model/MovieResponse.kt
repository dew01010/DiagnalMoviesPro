package com.example.diagnal.data.model

import com.google.gson.annotations.SerializedName


data class MovieResponse(
    val page: PageInfo? = null,
)

data class PageInfo(
    @SerializedName("title") val title: String,
    @SerializedName("content-items") val contentItem: ContentItem,
    @SerializedName("total-content-items") val totalItem: String,
    @SerializedName("page-num") val pageNo: String,
    @SerializedName("page-size") val pageSize: String,
)

data class ContentItem(
    @SerializedName("content") val movies: List<Movies>
)
